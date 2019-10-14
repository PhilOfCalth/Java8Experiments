package completableFuture.decorator;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class BorderDecorator extends Decorator{

    public BorderDecorator(VisualComponentInterface component) {
        this.component = component;
    }

    public String draw() {

        List<String> lines = Arrays.asList(super.draw().split("\n"));
        // Network call to get border style, for example
        simulateNetworkCall();
        StringBuilder borderedContent = new StringBuilder();

        // Doing this oldschool would be faster... But that's not what I'm testing, and this is more consise
        OptionalInt maxOpt  = lines.stream()
                .mapToInt(String::length)
                .max();
        int maxWidth = maxOpt.orElse(0);
        StringBuilder headerFooter = genorateHeaderFooter(maxWidth);

        borderedContent.append(headerFooter);
        borderedContent.append('\n');

        for(String line : lines)
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

    private StringBuilder genorateHeaderFooter(int width){

        StringBuilder headerFooter = new StringBuilder("+");

        for(int i = 0; i < width; i++){
            headerFooter.append('-');
        }
        headerFooter.append('+');
        return headerFooter;
    }
}
