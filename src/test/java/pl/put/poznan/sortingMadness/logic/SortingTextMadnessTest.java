package pl.put.poznan.sortingMadness.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.mockito.Mockito.*;

class SortingTextMadnessTest {
    private SortingTextMadness sortingTextMadness;
    private String[] input = new String[] {};
    private String[] expectedResult = new String[] {};

    @BeforeEach
    public void setUp() {
        input = new String[] {"e", "d", "c", "b", "a"};
        expectedResult = new String[] {"a", "b", "c", "d", "e"};
    }

    @Test
    void testTextContextBubbleSortStrategy(){
        String sortingType = "BUBBLE";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextContextMergeSortStrategy(){
        String sortingType = "MERGE";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextContextCountingSortStrategy(){
        String sortingType = "COUNTING";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextContextInsertionSortStrategy(){
        String sortingType = "INSERTION";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextContextQuickSortStrategy(){
        String sortingType = "QUICK";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextContextSelectionSortStrategy(){
        String sortingType = "SELECTION";
        SortContext mockObject = mock(SortContext.class);

        when(mockObject.sortingText(input)).thenReturn(expectedResult);
        sortingTextMadness = new SortingTextMadness(sortingType, mockObject);
        String[] result = sortingTextMadness.sort(input);

        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

}