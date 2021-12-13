package pl.put.poznan.sortingMadness.logic;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Bubble sort
 */
public class BubbleSortStrategy  implements SortStrategy {

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
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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
        int n = arr.length;

        String temp;

        for (int j = 0; j < n - 1; j++)
        {
            for (int i = j + 1; i < n; i++)
            {
                if (arr[j].compareTo(arr[i]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
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
    public JSONArray sortingObject(JSONArray arr, String sorting_attribute) {
        System.out.println(arr);
        System.out.println(sorting_attribute);
        System.out.println(arr.get(0));

        JSONObject[] arr2 = new JSONObject[arr.length()];

        for (int i = 0; i < arr.length(); i++) {
            JSONObject row = arr.getJSONObject(i);
            arr2[i] = row;
        }

        System.out.println(arr2[0].get(sorting_attribute));


        return arr;
    }
}
