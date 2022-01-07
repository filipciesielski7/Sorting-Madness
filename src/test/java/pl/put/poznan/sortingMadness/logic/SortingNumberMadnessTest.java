package pl.put.poznan.sortingMadness.logic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

class SortingNumberMadnessTest {
    private SortingNumberMadness sortingNumberMadness;
    private int[] input = new int[] {};
    private String[] inputStrings = new String[] {};
    private int[] expectedResult = new int[] {};

    @BeforeEach
    public void setUp() {
        inputStrings = new String[] {"5", "4", "3", "2", "1"};
        input = Stream.of(inputStrings).mapToInt(Integer::parseInt).toArray();
        expectedResult = new int[] {1, 2, 3, 4, 5};
    }

    @Test
    void testContextBubbleSortStrategy(){
        String sortingType = "BUBBLE";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testContextMergeSortStrategy(){
        String sortingType = "MERGE";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testContextCountingSortStrategy(){
        String sortingType = "COUNTING";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testContextInsertionSortStrategy(){
        String sortingType = "INSERTION";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testContextQuickSortStrategy(){
        String sortingType = "QUICK";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testContextSelectionSortStrategy(){
        String sortingType = "SELECTION";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sorting(input)).thenReturn(expectedResult);
        sortingNumberMadness = new SortingNumberMadness(sortingType, mockObject);
        int[] result = sortingNumberMadness.sort(inputStrings);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

}