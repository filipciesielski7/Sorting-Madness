package pl.put.poznan.sortingMadness.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        ArrayList<String> data = new ArrayList<String>(Arrays.asList(data_array));

        if(sorting_type.toUpperCase().equals("BUBBLE")){
            context = new SortContext(new BubbleSortStrategy());
            return ("Bubble sort result: " + context.sorting(data));
        }

        else if(sorting_type.toUpperCase().equals("BUCKET")) {
            context = new SortContext(new BucketSortStrategy());
            return ("Bucket sort result: " + context.sorting(data));
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new CountingSortStrategy());
            return ("Counting sort result: " + context.sorting(data));
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new InsertionSortStrategy());
            return ("Insertion sort result: " + context.sorting(data));
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new QuickSortStrategy());
            return ("Quick sort result: " + context.sorting(data));
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new SelectionSortStrategy());
            return ("Selection sort result: " + context.sorting(data));
        }

        return "Unknown sorting type";
    }
}
