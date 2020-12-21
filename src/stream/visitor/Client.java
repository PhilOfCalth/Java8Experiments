package stream.visitor;

import stream.visitor.cartElements.BiddableItemElement;
import stream.visitor.cartElements.ShoppingCartElement;
import stream.visitor.cartElements.VoucherElement;
import stream.visitor.pricingVisitors.PricingVisitor;
import stream.visitor.pricingVisitors.ShoppingCartVisitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args){
        List<ShoppingCartElement> shoppingCart = new ArrayList<>();
        shoppingCart.add(new BiddableItemElement(1, 10000));
        shoppingCart.add(new VoucherElement(16, 6000));
        shoppingCart.add(new BiddableItemElement(2, 500));
        shoppingCart.add(new BiddableItemElement(3, 2100));

        ShoppingCartVisitor visitor = new PricingVisitor();

        //org.apache.commons.lang3.time.StopWatch, if I was bothered with dependencies
        final long startTime = (new Date()).getTime();

        CartTotalResponse response = shoppingCart.parallelStream()
                        .map(element -> element.accept(visitor))
                        .collect(Collectors.teeing(
                                Collectors.summingInt(Integer::intValue),
                                Collectors.minBy(Integer::compareTo),
                                (sum, min) -> new CartTotalResponse(sum, min.orElse(0))));

        System.out.println("That took "+Long.toString((new Date()).getTime() - startTime)+"ms");
        System.out.println("The total billable for that cart is "+response.total+
                            ".\nYou could drop your cheapest item valued "+response.cheapestPrice);
    }

    //oh lombok where art thou
    private static class CartTotalResponse{
        int total;
        int cheapestPrice;

        public CartTotalResponse(int total, int cheapestPrice) {
            this.total = total;
            this.cheapestPrice = cheapestPrice;
        }
    }
}
