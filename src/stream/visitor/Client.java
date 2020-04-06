package stream.visitor;

import stream.visitor.cartElements.BiddableItemElement;
import stream.visitor.cartElements.ShoppingCartElement;
import stream.visitor.cartElements.VoucherElement;
import stream.visitor.pricingVisitors.PricingVisitor;
import stream.visitor.pricingVisitors.ShoppingCartVisitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    public static void main(String[] args){
        List<ShoppingCartElement> shoppingCart = new ArrayList<>();
        shoppingCart.add(new BiddableItemElement(1, 10000));
        shoppingCart.add(new VoucherElement(16, 6000));
        shoppingCart.add(new BiddableItemElement(2, 500));
        shoppingCart.add(new BiddableItemElement(3, 2100));

        ShoppingCartVisitor visitor = new PricingVisitor();
        int total = 0;

        //org.apache.commons.lang3.time.StopWatch, if I was bothered with dependencies
        final long startTime = (new Date()).getTime();

        for(ShoppingCartElement element : shoppingCart){
            total += element.accept(visitor);
        }

        System.out.println("That took "+Long.toString((new Date()).getTime() - startTime)+"ms");
        System.out.println("The total billble for that cart is "+total);
    }
}
