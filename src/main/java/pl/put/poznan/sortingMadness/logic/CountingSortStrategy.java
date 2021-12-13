package pl.put.poznan.sortingMadness.logic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
}
