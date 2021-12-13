package pl.put.poznan.sortingMadness.logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public List<Person> sortingObjects(List<Person> data_array, String field) {
        Comparator<Person> compare = (Person o1, Person o2) -> o1.getAge().compareTo( o2.getAge() );
        if (field.equals("age")) {
            compare = (Person o1, Person o2) -> o1.getAge().compareTo( o2.getAge() );
        } else if (field.equals("firstname")) {
            compare = (Person o1, Person o2) -> o1.getFirstName().compareTo(o2.getFirstName());
        } else if (field.equals("lastname")) {
            compare = (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName());
        }
        Collections.sort(data_array, compare);
        return data_array;
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

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
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
}
