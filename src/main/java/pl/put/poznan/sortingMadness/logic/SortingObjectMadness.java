package pl.put.poznan.sortingMadness.logic;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;
import java.util.Iterator;

public class SortingObjectMadness {
    private String sorting_type;
    private String sorting_attribute;
    private String sorted_list;
    private long timeElapsed;

    public SortingObjectMadness() {
    }

    public SortingObjectMadness(String sorting_type){
        this.sorting_type = sorting_type;
    }

    public SortingObjectMadness(String sorting_type, String sorted_list, long timeElapsed) {
        this.sorting_type = sorting_type;
        this.sorted_list = sorted_list;
        this.timeElapsed = timeElapsed;
    }

    public JSONArray sort(JSONArray data_array, String sorting_attribute) {

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

        return new JSONArray();

    }

    public String getSorting_type() {
        return sorting_type;
    }

    public void setSorting_type(String sorting_type) {
        this.sorting_type = sorting_type;
    }

    public String getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(String sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }
}
