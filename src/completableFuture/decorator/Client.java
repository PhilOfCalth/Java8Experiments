package completableFuture.decorator;

import java.util.Date;

public class Client {

    public static void main( String[] args ) {

        //org.apache.commons.lang3.time.StopWatch, if I was bothered with dependencies
        long startTime = (new Date()).getTime();
        VisualComponentInterface borderedComponent = new BorderDecorator(
                                                        new LineNumberDecorator(
                                                                new TextComponent("Hello World!\n" +
                                                                            "This is Phil, playing with his code.\n" +
                                                                            "Goodbye now!")));
        System.out.println("With Borders:\n"+borderedComponent.draw()+"\n");
        System.out.println("That took "+Long.toString((new Date()).getTime() - startTime)+"ms");

    }
}
