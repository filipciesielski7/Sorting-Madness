package pl.put.poznan.sortingMadness.logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
