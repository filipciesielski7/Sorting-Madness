package pl.put.poznan.sortingMadness.rest;

import org.json.JSONObject;

import java.util.List;

public class FinalObject {
    private Object sorting_types;
    private Object sorting_attribute;
    private List<JSONObject> sorted_list;
    private long[] time_elapsed_list;

    public FinalObject(Object sorting_types, Object sorting_attribute, List<JSONObject> sorted_list, long[] time_elapsed_list) {
        this.sorting_types = sorting_types;
        this.sorting_attribute = sorting_attribute;
        this.sorted_list = sorted_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public FinalObject(Object sorting_types, List<JSONObject> sorted_list, long[] time_elapsed_list) {
        this.sorting_types = sorting_types;
        this.sorted_list = sorted_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public Object getSorting_types() {
        return sorting_types;
    }

    public void setSorting_types(Object sorting_types) {
        this.sorting_types = sorting_types;
    }

    public Object getSorting_attribute() {
        return sorting_attribute;
    }

    public void setSorting_attribute(Object sorting_attribute) {
        this.sorting_attribute = sorting_attribute;
    }

    public List<JSONObject> getSorted_list() {
        return sorted_list;
    }

    public void setSorted_list(List<JSONObject> sorted_list) {
        this.sorted_list = sorted_list;
    }

    public long[] getTime_elapsed_list() {
        return time_elapsed_list;
    }

    public void setTime_elapsed_list(long[] time_elapsed_list) {
        this.time_elapsed_list = time_elapsed_list;
    }
}
