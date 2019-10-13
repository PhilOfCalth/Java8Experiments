package completableFuture.decorator;

public class Client {

    public static void main( String[] args ) {
        TextComponent textComponent = new TextComponent("Hello World!\n" +
                                                        "This is Phil, playing with his code.\n" +
                                                        "Goodbye now!");
        System.out.println("Origional:\n"+textComponent.draw()+"\n");

        VisualComponentInterface linedComponent = new LineNumberDecorator(textComponent);
        System.out.println("With Lines:\n"+linedComponent.draw()+"\n");

        VisualComponentInterface borderedComponent = new BorderDecorator(linedComponent);
        System.out.println("With Borders:\n"+borderedComponent.draw()+"\n");

    }
}
