package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;
import java.util.List;


public class SortingObjectMadness {
    private String sorting_type;
    private String sorting_attribute;
    private List<JSONObject> sorted_list;
    private long time_elapsed;

    public SortingObjectMadness() {
    }

    public SortingObjectMadness(String sorting_type){
        this.sorting_type = sorting_type;
    }

    public SortingObjectMadness(String sorting_type, List<JSONObject> sorted_list, long time_elapsed) {
        this.sorting_type = sorting_type;
        this.sorted_list = sorted_list;
        this.time_elapsed = time_elapsed;
    }

    public JSONObject[] sort(JSONObject[] data_array, String sorting_attribute) {

        SortContext context;

        if(sorting_type.toUpperCase().equals("BUBBLE")){
            context = new SortContext(new BubbleSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        else if(sorting_type.toUpperCase().equals("MERGE")) {
            context = new SortContext(new MergeSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        else if(sorting_type.toUpperCase().equals("COUNTING")) {
            context = new SortContext(new CountingSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        else if(sorting_type.toUpperCase().equals("INSERTION")) {
            context = new SortContext(new InsertionSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        else if(sorting_type.toUpperCase().equals("QUICK")) {
            context = new SortContext(new QuickSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        else if(sorting_type.toUpperCase().equals("SELECTION")) {
            context = new SortContext(new SelectionSortStrategy());
            return context.sortingObject(data_array, sorting_attribute);
        }

        return new JSONObject[0];

    }

    public String getSorting_type() {
        return sorting_type;
    }

    public void setSorting_type(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public List<JSONObject> getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(List<JSONObject> sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long getTime_elapsed() {
        return time_elapsed;
    }

    public void setTime_elapsed(long time_elapsed) {
        this.time_elapsed = time_elapsed;
    }
}
