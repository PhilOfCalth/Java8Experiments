package completableFuture.decorator;

import util.ThreadUtils;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class BorderDecorator extends Decorator{

    final CompletableFuture<String> styleResolver;

    public BorderDecorator(VisualComponentInterface component) {
        styleResolver = CompletableFuture.supplyAsync(BorderDecorator::queryStyle);
        this.component = component;
    }

    public String draw() throws ExecutionException, InterruptedException {

        final List<String> lines = Arrays.asList(super.draw().split("\n"));

        //Normally we'd do something with the style info we got back, but that is outside the scope of this experiment
        styleResolver.get();
        final StringBuilder borderedContent = new StringBuilder();

        // Doing this oldschool would be faster... But that's not what I'm testing, and this is more concise
        OptionalInt maxOpt  = lines.stream()
                .mapToInt(String::length)
                .max();
        final int maxWidth = maxOpt.orElse(0);
        final StringBuilder headerFooter = genorateHeaderFooter(maxWidth);

        borderedContent.append(headerFooter);
        borderedContent.append('\n');

        for(final String line : lines)
        {
             borderedContent.append('|');
             borderedContent.append(line);

             for(int i = line.length();  i < maxWidth; i++){
                 borderedContent.append(' ');
             }

             borderedContent.append('|');
             borderedContent.append('\n');
        }

        borderedContent.append(headerFooter);

        return borderedContent.toString();
    }

    private StringBuilder genorateHeaderFooter(final int width){

        final StringBuilder headerFooter = new StringBuilder("+");

        for(int i = 0; i < width; i++){
            headerFooter.append('-');
        }
        headerFooter.append('+');
        return headerFooter;
    }

    private static String queryStyle(){
        // Network call to get border style, for example
        ThreadUtils.simulateNetworkCall();
        //do static stuff
        return "gangnam";
    }
}
