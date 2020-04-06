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

}
