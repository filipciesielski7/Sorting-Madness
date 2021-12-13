package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;


public class SelectionSortStrategy implements SortStrategy {

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

    @Override
    public String[] sortingText(String[] array) {

        for ( int j=0; j < array.length-1; j++ )
        {
            int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 ) min = k;

            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }
        return array;
    }

    @Override
    public JSONObject[] sortingObject(JSONObject[] data_array, String sorting_attribute) {
        return data_array;
    }
}
