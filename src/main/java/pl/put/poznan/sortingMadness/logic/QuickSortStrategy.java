package pl.put.poznan.sortingMadness.logic;

public class QuickSortStrategy implements SortStrategy {

    @Override
    public int[] sorting(int[] arr) {
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    @Override
    public String[] sortingText(String[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quickSortText(left, right, arr);
        return arr;
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static void quickSortText(int left, int right, String[] arr) {
        if (left >= right)
            return;
        String pivot = getMedian(left, right, arr);
        int partition = partition(left, right, pivot, arr);

        quickSortText(0, partition-1, arr);
        quickSortText(partition+1, right, arr);
    }

    static int partition(int left, int right, String pivot, String[] arr) {
        int leftCursor = left-1;
        int rightCursor = right;
        while (leftCursor < rightCursor) {
            while(((Comparable<String>)arr[++leftCursor]).compareTo(pivot) < 0);
            while(rightCursor > 0 && ((Comparable<String>)arr[--rightCursor]).compareTo(pivot) > 0);
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swapText(arr, leftCursor, rightCursor);
            }
        }
        swapText(arr, leftCursor, right);
        return leftCursor;
    }

    static String getMedian(int left, int right, String[] arr) {
        int center = (left+right)/2;

        if(((Comparable<String>)arr[left]).compareTo(arr[center]) > 0)
            swapText(arr,left,center);
        if(((Comparable<String>)arr[left]).compareTo(arr[right]) > 0)
            swapText(arr, left, right);
        if(((Comparable<String>)arr[center]).compareTo(arr[right]) > 0)
            swapText(arr, center, right);

        swapText(arr, center, right);
        return arr[right];
    }

    static void swapText(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
