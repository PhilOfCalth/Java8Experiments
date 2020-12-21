package completableFuture.decorator;

public class TextComponent implements VisualComponentInterface {

    final private String content;

    public TextComponent(){
        this.content = "";
    }

    public TextComponent(final String content){
        this.content = content;
    }

    public String draw() {
        return content;
    }

    public String getContent(){
        return content;
    }
}
