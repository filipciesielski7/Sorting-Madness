package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;


/**
 * Insertion sort
 */
public class InsertionSortStrategy implements SortStrategy {

    /**
     * Numbers array sorting.
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @return sorted numbers array.
     */
    @Override
    public int[] sorting(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    /**
     * Strings array sorting.
     *
     * @param arr
     *            is the name of the data input strings array.
     * @return sorted strings array.
     */
    @Override
    public String[] sortingText(String[] arr) {
        int f = arr.length;

        String temp = "";

        for(int i = 0; i < f; i++) {
            for (int j = i + 1; j < f; j++) {
                if (arr[i].compareToIgnoreCase(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    /**
     * Objects array sorting.
     *
     * @param arr
     *            is the name of the data input objects array.
     * @param sorting_attribute
     *            is the name of the sorting based on attribute.
     * @return sorted objects array.
     */
    @Override
    public JSONObject[] sortingObject(JSONObject[] arr, String sorting_attribute) {
        if(arr[0].get(sorting_attribute) instanceof Integer){
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                JSONObject key = arr[i];
                int j = i - 1;

                while (j >= 0 && arr[j].getInt(sorting_attribute) > key.getInt(sorting_attribute)) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }

            return arr;
        }
        else if(arr[0].get(sorting_attribute) instanceof String){
            int f = arr.length;

            JSONObject temp;

            for(int i = 0; i < f; i++) {
                for (int j = i + 1; j < f; j++) {
                    if (arr[i].getString(sorting_attribute).compareToIgnoreCase(arr[j].getString(sorting_attribute)) > 0) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            return arr;
        }
        return arr;
    }
}
