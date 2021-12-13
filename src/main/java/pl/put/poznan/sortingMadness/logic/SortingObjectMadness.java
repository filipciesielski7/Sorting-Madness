package pl.put.poznan.sortingMadness.logic;

import java.util.List;

public class SortingObjectMadness {

    private String sorting_type;
    private List<Person> sorted_list;
    private String sortingAttribute;
    private long time_elapsed;

    public SortingObjectMadness() {

    }

    public SortingObjectMadness(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public List<Person> sort(List<Person> data_array, String sortingAttribute){

        List<Person> data = data_array;
        SortContext context;

        if(sorting_type.toUpperCase().equals("BUBBLE")){

            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);

        }




        else if(sorting_type.toUpperCase().equals("MERGE")) {
            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new BubbleSortStrategy());
            data = context.sortingObject(data_array, sortingAttribute);
        }

        return data;
    }




    public String getSorting_type() {
        return sorting_type;
    }

    public void setSorting_type(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public List<Person> getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(List<Person> sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long getTime_elapsed() {
        return time_elapsed;
    }

    public void setTime_elapsed(long time_elapsed) {
        this.time_elapsed = time_elapsed;
    }

    public String getSortingAttribute() {
        return sortingAttribute;
    }

    public void setSortingAttribute(String sortingAttribute) {
        this.sortingAttribute = sortingAttribute;
    }
}
