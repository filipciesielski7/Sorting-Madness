package pl.put.poznan.sortingMadness.logic;

import org.json.JSONObject;


/**
 * Merge sort
 */
public class MergeSortStrategy implements SortStrategy {

    /**
     * Numbers array sorting.
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @return sorted numbers array.
     */
    @Override
    public int[] sorting(int[] arr) {
        sort(arr, 0, arr.length-1);
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
        sortText(arr);
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
            sortObject(arr, 0, arr.length-1, sorting_attribute);
            return arr;
        }
        else if(arr[0].get(sorting_attribute) instanceof String){
            sortObjectText(arr, sorting_attribute);
            return arr;
        }
        return arr;
    }

    /**
     * Numbers array main merge sort function.
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @param l
     *            left index.
     * @param r
     *            right index.
     */
    void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    /**
     * Strings array main merge sort function.
     *
     * @param arr
     *            is the name of the data input strings array.
     */
    void sortText(String[] arr) {
        if (arr.length >= 2) {
            String[] left = new String[arr.length / 2];
            String[] right = new String[arr.length - arr.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = arr[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = arr[i + arr.length / 2];
            }

            sortText(left);
            sortText(right);
            mergeText(arr, left, right);
        }
    }

    /**
     * Objects array main merge sort function.
     *
     * @param arr
     *            is the name of the data input objects array.
     * @param l
     *            left index.
     * @param r
     *            right index.
     * @param sorting_attribute
     *            is the name of the integer sorting based on attribute.
     */
    void sortObject(JSONObject[] arr, int l, int r, String sorting_attribute)
    {
        if (l < r) {
            int m = l + (r-l) /2;

            sortObject(arr, l, m, sorting_attribute);
            sortObject(arr, m + 1, r, sorting_attribute);

            mergeObject(arr, l, m, r, sorting_attribute);
        }
    }

    /**
     * Objects array main merge sort function.
     *
     * @param arr
     *            is the name of the data input objects array.
     * @param sorting_attribute
     *            is the name of the string sorting based on attribute.
     */
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

    /**
     * Merge function to sort numbers array which
     * takes two intervals one from start to mid,
     * second from mid+1, to end and merge them
     * in sorted order
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @param l
     *            left index.
     * @param m
     *            mid index.
     * @param r
     *            right index.
     */
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

    /**
     * Merge function to sort strings array
     *
     * @param arr
     *            is the name of the data input numbers array.
     * @param left
     *            first strings subarray
     * @param right
     *            second strings subarray.
     */
    void mergeText(String[] arr, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                arr[i] = left[a];
                a++;
            } else {
                arr[i] = right[b];
                b++;
            }
        }
    }

    /**
     * Merge function to sort objects array which
     * takes two intervals one from start to mid,
     * second from mid+1, to end and merge them
     * in sorted order
     *
     * @param arr
     *            is the name of the data input objects array.
     * @param l
     *            left index.
     * @param m
     *            mid index.
     * @param r
     *            right index.
     * @param sorting_attribute
     *            is the name of the integer sorting based on attribute.
     */
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

    /**
     * Merge function to sort objects array
     * with string sorting based on attribute
     *
     * @param arr
     *            is the name of the data input objects array.
     * @param left
     *            first objects subarray
     * @param right
     *            second objects subarray.
     * @param sorting_attribute
     *            is the name of the string sorting based on attribute.
     */
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
