package pl.put.poznan.sortingMadness.logic;

import java.util.stream.Stream;


public class SortingMadness {

    private String sorting_type;
    private int[] sorted_list;
    private long timeElapsed;

    public SortingMadness() {
    }

    public SortingMadness(String sorting_type){
        this.sorting_type = sorting_type;

    }


    public SortingMadness(String sorting_type, int[] sorted_list, long timeElapsed) {
        this.sorting_type = sorting_type;
        this.sorted_list = sorted_list;
        this.timeElapsed = timeElapsed;
    }

    public int[] sort(String[] data_array){

        int [] data = Stream.of(data_array).mapToInt(Integer::parseInt).toArray();
        SortContext context;

        if(sorting_type.toUpperCase().equals("BUBBLE")){
            context = new SortContext(new BubbleSortStrategy());
            return context.sorting(data);
        }

        else if(sorting_type.toUpperCase().equals("MERGE")) {
            context = new SortContext(new MergeSortStrategy());
            return context.sorting(data);
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new CountingSortStrategy());
            return context.sorting(data);
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new InsertionSortStrategy());
            return context.sorting(data);
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new QuickSortStrategy());
            return context.sorting(data);
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new SelectionSortStrategy());
            return context.sorting(data);
        }


        return new int[0];
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

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

}
