package pl.put.poznan.sortingMadness.logic;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class SortingMadness {

    private final String sorting_type;
    private SortContext context;

    public SortingMadness(String sorting_type){
        this.sorting_type = sorting_type;
    }

    public String sort(String[] data_array){

        int [] data = Stream.of(data_array).mapToInt(Integer::parseInt).toArray();

        if(sorting_type.toUpperCase().equals("BUBBLE")){
            context = new SortContext(new BubbleSortStrategy());
            return ("Bubble sort result: " + Arrays.toString(context.sorting(data)));
        }

        else if(sorting_type.toUpperCase().equals("MERGE")) {
            context = new SortContext(new MergeSortStrategy());
            return ("Merge sort result: " + Arrays.toString(context.sorting(data)));
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new CountingSortStrategy());
            return ("Counting sort result: " + Arrays.toString(context.sorting(data)));
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new InsertionSortStrategy());
            return ("Insertion sort result: " + Arrays.toString(context.sorting(data)));
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new QuickSortStrategy());
            return ("Quick sort result: " + Arrays.toString(context.sorting(data)));
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new SelectionSortStrategy());
            return ("Selection sort result: " + Arrays.toString(context.sorting(data)));
        }

        return "Unknown sorting type";
    }
}
