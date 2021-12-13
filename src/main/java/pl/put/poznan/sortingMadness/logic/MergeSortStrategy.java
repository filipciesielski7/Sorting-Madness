package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;


public class MergeSortStrategy implements SortStrategy {
    @Override
    public int[] sorting(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }

    @Override
    public String[] sortingText(String[] data_array) {
        sortText(data_array);
        return data_array;
    }

    @Override
    public JSONObject[] sortingObject(JSONObject[] arr, String sorting_attribute) {
        if(arr[0].get(sorting_attribute) instanceof Integer) {
            sortObject(arr, 0, arr.length-1, sorting_attribute);
            return arr;
        }
        else if(arr[0].get(sorting_attribute) instanceof String){
            sortObjectText(arr, sorting_attribute);
            return arr;
        }
        return arr;
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    void sortText(String[] names) {
        if (names.length >= 2) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            sortText(left);
            sortText(right);
            mergeText(names, left, right);
        }
    }

    void sortObject(JSONObject[] arr, int l, int r, String sorting_attribute)
    {
        if (l < r) {
            int m = l + (r-l) /2;

            sortObject(arr, l, m, sorting_attribute);
            sortObject(arr, m + 1, r, sorting_attribute);

            mergeObject(arr, l, m, r, sorting_attribute);
        }
    }

    void sortObjectText(JSONObject[] arr, String sorting_attribute) {
        if (arr.length >= 2) {
            JSONObject[] left = new JSONObject[arr.length / 2];
            JSONObject[] right = new JSONObject[arr.length - arr.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = arr[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = arr[i + arr.length / 2];
            }

            sortObjectText(left, sorting_attribute);
            sortObjectText(right, sorting_attribute);
            mergeObjectText(arr, left, right, sorting_attribute);
        }
    }

    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeText(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }

    void mergeObject(JSONObject[] arr, int l, int m, int r, String sorting_attribute)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        JSONObject L[] = new JSONObject[n1];
        JSONObject R[] = new JSONObject[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getInt(sorting_attribute) <= R[j].getInt(sorting_attribute)) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeObjectText(JSONObject[] arr, JSONObject[] left, JSONObject[] right, String sorting_attribute) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (b >= right.length || (a < left.length && left[a].getString(sorting_attribute).compareToIgnoreCase(right[b].getString(sorting_attribute)) < 0)) {
                arr[i] = left[a];
                a++;
            } else {
                arr[i] = right[b];
                b++;
            }
        }
    }
}
