package completableFuture.decorator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LineNumberDecorator extends Decorator{

    CompletableFuture<Integer> startLineResolver;

    public LineNumberDecorator(VisualComponentInterface component) {

        startLineResolver = CompletableFuture.supplyAsync(this::findStartNumber);
        this.component = component;
    }

    public String draw() throws ExecutionException, InterruptedException {

        // Network call to get a line number, for example
        int startNumber = startLineResolver.get();

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

    private int findStartNumber(){
        // Network call to get border style, for example
        simulateNetworkCall();
        //do stuff that relates to this object
        return 0;
    }
}
