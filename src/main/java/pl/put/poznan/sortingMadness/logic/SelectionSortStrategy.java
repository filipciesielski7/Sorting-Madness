package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;

/**
 * Selection sort
 */
public class SelectionSortStrategy implements SortStrategy {

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
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
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

        for ( int j=0; j < arr.length-1; j++ )
        {
            int min = j;
            for ( int k=j+1; k < arr.length; k++ )
                if ( arr[k].compareTo( arr[min] ) < 0 ) min = k;

            String temp = arr[j];
            arr[j] = arr[min];
            arr[min] = temp;
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
        if(arr[0].get(sorting_attribute) instanceof Integer) {
            int n = arr.length;

            for (int i = 0; i < n-1; i++)
            {
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (arr[j].getInt(sorting_attribute) < arr[min_idx].getInt(sorting_attribute))
                        min_idx = j;

                JSONObject temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }

            return arr;
        }
        else if(arr[0].get(sorting_attribute) instanceof String){
            for ( int j=0; j < arr.length-1; j++ )
            {
                int min = j;
                for ( int k=j+1; k < arr.length; k++ )
                    if ( arr[k].getString(sorting_attribute).compareTo(arr[min].getString(sorting_attribute)) < 0 ) min = k;

                JSONObject temp = arr[j];
                arr[j] = arr[min];
                arr[min] = temp;
            }
            return arr;
        }
        return arr;
    }
}
