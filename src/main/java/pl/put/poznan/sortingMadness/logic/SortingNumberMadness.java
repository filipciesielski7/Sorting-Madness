package pl.put.poznan.sortingMadness.logic;

import java.util.stream.Stream;


public class SortingNumberMadness {

    private String sorting_type;
    private int[] sorted_list;
    private long time_elapsed;
    private SortContext sortContext = null;

    public SortingNumberMadness() {
    }

    public SortingNumberMadness(String sorting_type){
        this.sorting_type = sorting_type;
    }

    public SortingNumberMadness(String sorting_type, SortContext sortContext){
        this.sorting_type = sorting_type;
        this.sortContext = sortContext;
    }

    public SortingNumberMadness(String sorting_type, int[] sorted_list, long time_elapsed) {
        this.sorting_type = sorting_type;
        this.sorted_list = sorted_list;
        this.time_elapsed = time_elapsed;
    }

    public int[] sort(String[] data_array){

        int [] data = Stream.of(data_array).mapToInt(Integer::parseInt).toArray();
        SortContext context;

        if(sortContext == null) {
            if (sorting_type.toUpperCase().equals("BUBBLE")) {
                context = new SortContext(new BubbleSortStrategy());
                return context.sorting(data);
            } else if (sorting_type.toUpperCase().equals("MERGE")) {
                context = new SortContext(new MergeSortStrategy());
                return context.sorting(data);
            } else if (sorting_type.toUpperCase().equals("COUNTING")) {
                context = new SortContext(new CountingSortStrategy());
                return context.sorting(data);
            } else if (sorting_type.toUpperCase().equals("INSERTION")) {
                context = new SortContext(new InsertionSortStrategy());
                return context.sorting(data);
            } else if (sorting_type.toUpperCase().equals("QUICK")) {
                context = new SortContext(new QuickSortStrategy());
                return context.sorting(data);
            } else if (sorting_type.toUpperCase().equals("SELECTION")) {
                context = new SortContext(new SelectionSortStrategy());
                return context.sorting(data);
            }

            return new int[0];
        }
        else {
            context = sortContext;
            return context.sorting(data);
        }
    }

    public String getSorting_type() {
        return sorting_type;
    }

    public void setSorting_type(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public int[] getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(int[] sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long getTime_elapsed() {
        return time_elapsed;
    }

    public void setTime_elapsed(long time_elapsed) {
        this.time_elapsed = time_elapsed;
    }

}
