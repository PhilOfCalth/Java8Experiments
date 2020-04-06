package stream.visitor.cartElements;

import stream.visitor.pricingVisitors.ShoppingCartVisitor;

public class BiddableItemElement implements ShoppingCartElement {
    private final long id;
    private int offerPrice;

    public BiddableItemElement(long id, int offerPrice) {
        this.id = id;
        this.offerPrice = offerPrice;
    }

    public int accept(ShoppingCartVisitor visitor) {
        return visitor.price(this);
    }


    public long getId() { return id; }
    public int getOfferPrice() { return offerPrice; }

    public void setOfferPrice(int offerPrice) { this.offerPrice = offerPrice; }
}
