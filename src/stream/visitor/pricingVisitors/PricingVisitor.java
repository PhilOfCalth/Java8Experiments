package stream.visitor.pricingVisitors;

import stream.visitor.cartElements.BiddableItemElement;
import stream.visitor.cartElements.VoucherElement;

public class PricingVisitor implements ShoppingCartVisitor {

    public int price(BiddableItemElement biddableItemElement) {
        //Call pricing engine to get a counter offer, and accept or a reject
        return biddableItemElement.getOfferPrice() + 100;
    }

    public int price(VoucherElement voucherElement) {
        return voucherElement.getPrice();
    }
}
