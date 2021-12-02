package pl.put.poznan.sortingMadness.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class SortingMadness {

    private final String[] numbers_array;

    public SortingMadness(String[] numbers_array){
        this.numbers_array = numbers_array;
    }

    public String sort(String numbers_array){
        // of course, normally it would do something based on the sorting types
        return numbers_array.toUpperCase();
    }
}
