package pl.put.poznan.sortingMadness.logic;

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
}
