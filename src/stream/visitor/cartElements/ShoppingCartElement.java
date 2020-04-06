package stream.visitor.cartElements;

import stream.visitor.pricingVisitors.ShoppingCartVisitor;

public interface ShoppingCartElement {
    int accept(final ShoppingCartVisitor visitor);

    long getId();
}
