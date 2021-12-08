package pl.put.poznan.sortingMadness.logic;

import java.util.ArrayList;

public class BubbleSortStrategy  implements SortStrategy {

    @Override
    public ArrayList<String> sorting(ArrayList<String> data_array) {

        int[] arr = data_array.stream().mapToInt(i -> Integer.parseInt(i)).toArray();

        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

        ArrayList <String> sorted_array = new ArrayList<String>();
        for (int i : arr)
        {
            sorted_array.add(String.valueOf(i));
        }

        return sorted_array;
    }
}
