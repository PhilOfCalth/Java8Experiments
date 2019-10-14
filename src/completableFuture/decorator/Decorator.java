package completableFuture.decorator;

public abstract class Decorator implements VisualComponentInterface {

    protected VisualComponentInterface component;

    public String draw() {
        return component.draw();
    }

    public String getContent(){
        return component.getContent();
    }

    /**
     * Quick and easy way to simulate a call to a database, microservice, etc
     */
    protected void simulateNetworkCall(){
        try {
            Thread.sleep(3000);//3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
