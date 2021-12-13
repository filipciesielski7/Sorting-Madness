package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;
import java.util.Arrays;


/**
 * Counting sort
 */
public class CountingSortStrategy implements SortStrategy {

    /**
     * Numbers array sorting.
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @return sorted numbers array.
     */
    @Override
    public int[] sorting(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
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

    @Override
    public JSONObject[] sortingObject(JSONObject[] arr, String sorting_attribute) {
        if(arr[0].get(sorting_attribute) instanceof Integer) {
            int max = arr[0].getInt(sorting_attribute);
            int min = arr[0].getInt(sorting_attribute);

            for(int i = 0; i < arr.length; i++){
                if(arr[i].getInt(sorting_attribute) >= max){
                    max = arr[i].getInt(sorting_attribute);
                }
                if(arr[i].getInt(sorting_attribute) <= min) {
                    min = arr[i].getInt(sorting_attribute);
                }
            }

            int range = max - min + 1;
            int count[] = new int[range];
            JSONObject output[] = new JSONObject[arr.length];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i].getInt(sorting_attribute) - min]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                output[count[arr[i].getInt(sorting_attribute) - min] - 1] = arr[i];
                count[arr[i].getInt(sorting_attribute) - min]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }

            return arr;
        }
        else if(arr[0].get(sorting_attribute) instanceof String){
            int n = arr.length;

            JSONObject temp;

            for (int j = 0; j < n - 1; j++)
            {
                for (int i = j + 1; i < n; i++)
                {
                    if (arr[j].getString(sorting_attribute).compareTo(arr[i].getString(sorting_attribute)) > 0)
                    {
                        temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }

            return arr;
        }
        return arr;
    }
}
