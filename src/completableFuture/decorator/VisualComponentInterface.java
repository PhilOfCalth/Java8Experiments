package completableFuture.decorator;

import java.util.concurrent.ExecutionException;

public interface VisualComponentInterface
{
    String draw() throws ExecutionException, InterruptedException;
    String getContent();
}
