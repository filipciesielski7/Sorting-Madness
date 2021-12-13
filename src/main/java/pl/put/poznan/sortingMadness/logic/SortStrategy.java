package pl.put.poznan.sortingMadness.logic;


import java.util.List;

/**
 * Sort strategy
 */
public interface SortStrategy {

    /**
     * Numbers sorting.
     *
     * @param data_array
     *            is the name of the data input numbers array.
     * @return sorted numbers array.
     */
    public int[] sorting(int[] data_array);

    /**
     * Strings sorting.
     *
     * @param data_array
     *            is the name of the data input strings array.
     * @return sorted strings array.
     */
    public String[] sortingText(String[] data_array);

    public List<Person> sortingObjects(List<Person> data_array, String field);

}
