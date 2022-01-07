package pl.put.poznan.sortingMadness.logic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SelectionSortStrategyTest {
    private SelectionSortStrategy selectionSortStrategy = new SelectionSortStrategy();
    private int[] inputIntegers = new int[]{};
    private int[] expectedResultIntegers = new int[]{};

    private String[] inputStrings = new String[]{};
    private String[] expectedResultStrings = new String[]{};

    private JSONObject[] inputObjects = new JSONObject[] {};
    private JSONObject[] expectedResultObjects = new JSONObject[] {};

    @BeforeEach
    public void SetUp(){
        inputIntegers = new int[] {5, 4, 3, 2, 1};
        expectedResultIntegers = new int[] {1, 2, 3, 4, 5};

        inputStrings = new String[] {"e", "d", "c", "b", "a"};
        expectedResultStrings = new String[] {"a", "b", "c", "d", "e"};

        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Michał");
            object1.put("age", 21);

            object2.put("name", "Filip");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        inputObjects = new JSONObject[] {object1, object2};
        expectedResultObjects = new JSONObject[] {object2, object1};

    }

    @Test
    void testBubbleSortStrategy(){
        int[] result = selectionSortStrategy.sorting(inputIntegers);
        Assertions.assertTrue(Arrays.equals(expectedResultIntegers, result));
    }

    @Test
    void testTextBubbleSortStrategy(){
        String[] result = selectionSortStrategy.sortingText(inputStrings);
        Assertions.assertTrue(Arrays.equals(expectedResultStrings, result));
    }

    @Test
    void testObjectBubbleSortStrategy(){
        String sortingAttribute = "age";
        JSONObject[] result = selectionSortStrategy.sortingObject(inputObjects, sortingAttribute);
        Assertions.assertTrue(Arrays.equals(expectedResultObjects, result));
    }

    @Test
    void testTextObjectBubbleSortStrategy(){
        String sortingAttribute = "name";
        JSONObject[] result = selectionSortStrategy.sortingObject(inputObjects, sortingAttribute);
        Assertions.assertTrue(Arrays.equals(expectedResultObjects, result));
    }
}