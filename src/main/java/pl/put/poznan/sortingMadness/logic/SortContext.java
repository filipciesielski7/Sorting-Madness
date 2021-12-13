package pl.put.poznan.sortingMadness.logic;

import org.json.JSONArray;

public class SortContext {
    private SortStrategy sortStrategy;

    public SortContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public int[] sorting(int[] data_array){
        return sortStrategy.sorting(data_array);
    }

    public String[] sortingText(String[] data_array) {
        return sortStrategy.sortingText(data_array);
    }

    public JSONArray sortingObject(JSONArray data_array, String sorting_attribute) {
        return sortStrategy.sortingObject(data_array, sorting_attribute);
    }
}
