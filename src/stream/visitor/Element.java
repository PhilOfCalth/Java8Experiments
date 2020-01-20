package stream.visitor;

public interface Element {
    void accept(final Visitor visitor);
}
