package completableFuture.decorator;

import java.util.concurrent.ExecutionException;

public abstract class Decorator implements VisualComponentInterface {

    protected VisualComponentInterface component;

    public String draw() throws ExecutionException, InterruptedException {
        return component.draw();
    }

    public String getContent(){
        return component.getContent();
    }

    /**
     * Quick and easy way to simulate a call to a database, microservice, etc
     */
    protected static void simulateNetworkCall(){
        try {
            Thread.sleep(3000);//3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
