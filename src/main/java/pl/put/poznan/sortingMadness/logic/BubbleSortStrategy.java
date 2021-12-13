package pl.put.poznan.sortingMadness.logic;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Bubble sort
 */
public class BubbleSortStrategy  implements SortStrategy {

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
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
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
