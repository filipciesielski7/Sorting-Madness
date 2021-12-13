package pl.put.poznan.sortingMadness.logic;


import org.json.JSONArray;

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

    /**
     * Strings sorting.
     *
     * @param data_array
     *            is the name of the data input objects array.
     * @param sorting_attribute
     *            is the name of the sorting based on attribute.
     * @return sorted objects array.
     */
    public JSONArray sortingObject(JSONArray data_array, String sorting_attribute);
}
