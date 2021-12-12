package pl.put.poznan.sortingMadness.logic;

public class InsertionSortStrategy implements SortStrategy {

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

    @Override
    public String[] sortingText(String[] arr) {
        int f = arr.length;

        String temp = "";

        for(int i=0;i<f;i++) {
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


}
