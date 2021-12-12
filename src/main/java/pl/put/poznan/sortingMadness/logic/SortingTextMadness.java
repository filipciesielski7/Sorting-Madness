package pl.put.poznan.sortingMadness.logic;

import java.time.Instant;

public class SortingTextMadness {
    private String sorting_type;
    private String[] sorted_list;
    private long timeElapsed;

    public SortingTextMadness() {
    }

    public SortingTextMadness(String sorting_type){
        this.sorting_type = sorting_type;

    }


    public SortingTextMadness(String sorting_type, String[] sorted_list, long timeElapsed) {
        this.sorting_type = sorting_type;
        this.sorted_list = sorted_list;
        this.timeElapsed = timeElapsed;
    }

    public String[] sort(String[] data_array) {
        String [] data = data_array;
        SortContext context;
        Instant start = Instant.now();
        if(sorting_type.toUpperCase().equals("BUBBLE")){
            context = new SortContext(new BubbleSortStrategy());
            return context.sortingText(data);
        }

        else if(sorting_type.toUpperCase().equals("MERGE")) {
            context = new SortContext(new MergeSortStrategy());
            return context.sortingText(data);
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new CountingSortStrategy());
            return context.sortingText(data);
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new InsertionSortStrategy());
            return context.sortingText(data);
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new QuickSortStrategy());
            return context.sortingText(data);
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new SelectionSortStrategy());
            return context.sortingText(data);
        }

        return new String[0];

    }

    public String getSorting_type() {
        return sorting_type;
    }

    public void setSorting_type(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public String[] getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(String[] sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
