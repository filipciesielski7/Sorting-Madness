package pl.put.poznan.sortingMadness.rest;

import org.json.JSONObject;

import java.util.List;

public class FinalObject {
    private Object sorting_types;
    private String[] sorting_string_types;
    private Object sorting_attribute;
    private List<JSONObject> sorted_list;
    private List<String> sorted_text_list;
    private List<Integer> sorted_number_list;
    private long[] time_elapsed_list;

    public FinalObject(Object sorting_types, Object sorting_attribute, List<JSONObject> sorted_list, long[] time_elapsed_list) {
        this.sorting_types = sorting_types;
        this.sorting_attribute = sorting_attribute;
        this.sorted_list = sorted_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public FinalObject(Object sorting_types, List<String> sorted_text_list, long[] time_elapsed_list) {
        this.sorting_types = sorting_types;
        this.sorted_text_list = sorted_text_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public FinalObject(Object sorting_types, long[] time_elapsed_list, List<Integer> sorted_number_list) {
        this.sorting_types = sorting_types;
        this.sorted_number_list = sorted_number_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public FinalObject(String[] sorting_string_types, List<Integer> sorted_number_list, long[] time_elapsed_list) {
        this.sorting_string_types = sorting_string_types;
        this.sorted_number_list = sorted_number_list;
        this.time_elapsed_list = time_elapsed_list;
    }

    public FinalObject(String[] sorting_string_types, long[] time_elapsed_list, List<String> sorted_text_list) {
        this.sorting_string_types = sorting_string_types;
        this.sorted_text_list = sorted_text_list;
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

    public List<String> getSorted_text_list() {
        return sorted_text_list;
    }

    public List<Integer> getSorted_number_list() {
        return sorted_number_list;
    }

    public void setSorted_number_list(List<Integer> sorted_number_list) {
        this.sorted_number_list = sorted_number_list;
    }

    public void setSorted_text_list(List<String> sorted_text_list) {
        this.sorted_text_list = sorted_text_list;
    }

    public long[] getTime_elapsed_list() {
        return time_elapsed_list;
    }

    public void setTime_elapsed_list(long[] time_elapsed_list) {
        this.time_elapsed_list = time_elapsed_list;
    }

    public String[] getSorting_string_types() {
        return sorting_string_types;
    }

    public void setSorting_string_types(String[] sorting_string_types) {
        this.sorting_string_types = sorting_string_types;
    }
}
