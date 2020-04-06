package stream.visitor;

import stream.visitor.cartElements.BiddableItemElement;
import stream.visitor.cartElements.ShoppingCartElement;
import stream.visitor.cartElements.VoucherElement;
import stream.visitor.pricingVisitors.PricingVisitor;
import stream.visitor.pricingVisitors.ShoppingCartVisitor;

import java.util.ArrayList;
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

        for(ShoppingCartElement element : shoppingCart){
            total += element.accept(visitor);
        }

        System.out.println("The total billble for that cart is "+total);
    }
}
