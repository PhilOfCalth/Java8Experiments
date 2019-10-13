package completableFuture.decorator;

public class TextComponent implements VisualComponentInterface {

    private String content;

    public TextComponent(){
        this.content = "";
    }

    public TextComponent(String content){
        this.content = content;
    }

    public String draw() {
        return content;
    }

    public String getContent(){
        return content;
    }
}
