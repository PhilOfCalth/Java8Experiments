package completableFuture.decorator;

import util.ThreadUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class LineNumberDecorator extends Decorator{

    final CompletableFuture<Integer> startLineResolver;

    public LineNumberDecorator(final VisualComponentInterface component) {

        startLineResolver = CompletableFuture.supplyAsync(this::findStartNumber);
        this.component = component;
    }

    public String draw() throws ExecutionException, InterruptedException {

        // Network call to get a line number, for example
        final int startNumber = startLineResolver.get();

        final String[] lines = component.draw().split("\n");
        final StringBuilder numberedContent = new StringBuilder();

        for(int lineNumber = startNumber; lineNumber < lines.length + startNumber; lineNumber++){

            numberedContent.append(lineNumber);
            numberedContent.append(": ");
            numberedContent.append(lines[lineNumber - 1]);
            numberedContent.append('\n');
        }

        return numberedContent.toString();
    }

    private int findStartNumber(){
        // Network call to get border style, for example
        ThreadUtils.simulateNetworkCall();
        //do stuff that relates to this object
        return 1;
    }
}
