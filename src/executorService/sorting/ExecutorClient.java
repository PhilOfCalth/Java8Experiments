package executorService.sorting;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ExecutorClient {

    private static Random random = new Random();
    private static DecimalFormat numberFormatter = new DecimalFormat("#,###,###,##0");

    public static void main(String... args) throws ExecutionException, InterruptedException {
        var len10 = generateRandomArray(10);
        raceAlgorithms(len10);

        var len100 = generateRandomArray(100);
        raceAlgorithms(len100);

        var len1000 = generateRandomArray(1000);
        raceAlgorithms(len1000);

        var len1Million = generateRandomArray(1000_000);
        raceAlgorithms(len1Million);

    }

    private static void raceAlgorithms(int arr[]) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Set<Callable<String>> algorithms = Set.of(
                () -> timer(Algorithms::bubblesort, arr.clone(), "Bubblesort"),
                () -> timer(Algorithms::insertionsort, arr.clone(), "Insertionsort"),
                () -> timer(Algorithms::quicksort, arr.clone(), "Quicksort"),
                () -> timer(Algorithms::heapsort, arr.clone(), "Heapsort")
        );

        System.out.println(executor.invokeAny(algorithms));
        executor.shutdown();
    }

    private static int[] generateRandomArray(int length){
        var arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = random.nextInt();
        }
        return arr;
    }

    static String timer(Consumer<int[]> consumer, int arr[], String title){

        var startNanos = System.nanoTime();
        consumer.accept(arr);
        var formattedTiming = numberFormatter.format((System.nanoTime() - startNanos));

        return title+" sorted "+arr.length+" length array in "+formattedTiming+"ns";
    }
}
