package stream.visitor.cartElements;

import stream.visitor.pricingVisitors.ShoppingCartVisitor;

public class VoucherElement implements ShoppingCartElement {

    private final long id;
    private final int price;

    public VoucherElement(long id, int price) {
        this.id = id;
        this.price = price;
    }

    public int accept(ShoppingCartVisitor visitor) {
        return visitor.price(this);
    }


    public long getId() { return id; }
    public int getPrice() { return price; }
}
