package completableFuture.decorator;

public abstract class Decorator implements VisualComponentInterface {

    protected VisualComponentInterface component;

    public String draw() {
        return component.draw();
    }

    public String getContent(){
        return component.getContent();
    }

}
