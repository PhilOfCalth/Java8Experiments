package completableFuture.decorator;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Client {

    public static void main(final String[] args ) {

        //org.apache.commons.lang3.time.StopWatch, if I was bothered with dependencies
        final long startTime = (new Date()).getTime();
        final VisualComponentInterface borderedComponent = new BorderDecorator(
                                                        new LineNumberDecorator(
                                                                new TextComponent("Hello World!\n" +
                                                                            "This is Phil, playing with his code.\n" +
                                                                            "Goodbye now!")));
        try {
            System.out.println(borderedComponent.draw()+"\n");
        } catch (ExecutionException |InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("That took "+Long.toString((new Date()).getTime() - startTime)+"ms");

    }
}
