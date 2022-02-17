package executorService.sorting;

import java.util.Arrays;
import java.util.function.Consumer;

public class Algorithms {
    private Algorithms(){}

    /**
     * Bubblesort
     * Repeatedly swap the adjacent elements if they are in the wrong order.
     * Time Complexity: O( n^2 )
     */
    static void bubblesort(int arr[]){

        int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Insertionsort
     * Moves through the array and 1 at a time moves 1 element such that the left side becomes sorted.
     * Time Complexity: O( n^2 )
     */
    static void insertionsort(int arr[])
    {
        int length = arr.length;
        for (int i = 1; i < length; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Dual-Pivot Quicksort
     * Chooses 2 "pivots", uses them to partition the array moving values based on if they are greater than or
     * less than the pivot. Then recursively does the same to each pivot partitioned sub-array.
     * Time Complexity: O(n log(n))
     */
    static String quicksort(int arr[]){
        var startNanos = System.nanoTime();
        Arrays.sort(arr);
        return "QuickSorted "+Arrays.toString(arr)+" \nin "+(System.nanoTime() - startNanos)+"ns";
    }

    /**
     * Heapsort
     * Converts to a binary tree like structure and then swaps nodes with their ancestors,
     * to sort from right (greatest) to left (least)
     * Time Complexity: O(n log(n))
     */
    static void heapsort(int arr[])
    {
        int length = arr.length;

        // Build heap (rearrange array)
        for (int i = length / 2 - 1; i >= 0; i--)
            heapify(arr, length, i);

        // One by one extract an element from heap
        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is
     * an index in arr[]. n is size of heap
     */
    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

}
