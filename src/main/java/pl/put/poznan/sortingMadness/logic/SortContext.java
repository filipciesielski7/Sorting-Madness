package pl.put.poznan.sortingMadness.logic;

import pl.put.poznan.sortingMadness.logic.SortStrategy;

import java.util.ArrayList;

public class SortContext {
    private SortStrategy sortStrategy;

    public SortContext(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public ArrayList<String> sorting(ArrayList<String> data_array){
        return sortStrategy.sorting(data_array);
    }
}
