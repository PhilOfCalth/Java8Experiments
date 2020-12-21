package stream.visitor.pricingVisitors;

import stream.visitor.cartElements.BiddableItemElement;
import stream.visitor.cartElements.VoucherElement;

public interface ShoppingCartVisitor {
    int price(BiddableItemElement biddableItemElement);
    int price(VoucherElement voucherElement);
}
