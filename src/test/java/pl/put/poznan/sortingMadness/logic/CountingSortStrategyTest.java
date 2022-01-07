package pl.put.poznan.sortingMadness.logic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CountingSortStrategyTest {
    private CountingSortStrategy countingSortStrategy = new CountingSortStrategy();
    int[] inputIntegers = new int[]{};
    int[] expectedResultIntegers = new int[] {};

    String[] inputStrings = new String[]{};
    String[] expectedResultStrings = new String[] {};

    private JSONObject[] inputObjects = new JSONObject[] {};
    private JSONObject[] expectedResultObjects = new JSONObject[] {};

    private JSONObject object1 = new JSONObject();
    private JSONObject object2 = new JSONObject();

    @BeforeEach
    public void setUp() {
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
    void testCountingSortStrategy(){
        int[] result = countingSortStrategy.sorting(inputIntegers);
        Assertions.assertTrue(Arrays.equals(expectedResultIntegers, result));
    }

    @Test
    void testTextCountingSortStrategy(){
        String[] result = countingSortStrategy.sortingText(inputStrings);
        Assertions.assertTrue(Arrays.equals(expectedResultStrings, result));
    }

    @Test
    void testObjectCountingSortStrategy(){
        String sortingAttribute = "age";
        JSONObject[] result = countingSortStrategy.sortingObject(inputObjects, sortingAttribute);
        Assertions.assertTrue(Arrays.equals(expectedResultObjects, result));
    }

    @Test
    void testTextObjectCountingSortStrategy(){
        String sortingAttribute = "name";
        JSONObject[] result = countingSortStrategy.sortingObject(inputObjects, sortingAttribute);
        Assertions.assertTrue(Arrays.equals(expectedResultObjects, result));
    }

}