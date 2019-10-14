package completableFuture.decorator;

public class LineNumberDecorator extends Decorator{

    public LineNumberDecorator(VisualComponentInterface component) {
        this.component = component;
    }

    public String draw() {

        // Network call to get a line number, for example
        simulateNetworkCall();

        String[] lines = component.draw().split("\n");
        StringBuilder numberedContent = new StringBuilder();

        for(int lineNumber = 1; lineNumber <= lines.length; lineNumber++){

            numberedContent.append(lineNumber);
            numberedContent.append(": ");
            numberedContent.append(lines[lineNumber - 1]);
            numberedContent.append('\n');
        }

        return numberedContent.toString();
    }
}
