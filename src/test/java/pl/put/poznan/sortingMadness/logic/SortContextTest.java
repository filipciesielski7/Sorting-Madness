package pl.put.poznan.sortingMadness.logic;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortContextTest {
    private SortContext sortContext = null;

    @Test
    void testBubbleSortStrategy(){
        sortContext = new SortContext(new BubbleSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testCountingSortStrategy(){
        sortContext = new SortContext(new CountingSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testInsertionSortStrategy(){
        sortContext = new SortContext(new InsertionSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testMergeSortStrategy(){
        sortContext = new SortContext(new MergeSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testQuickSortStrategy(){
        sortContext = new SortContext(new QuickSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testSelectionSortStrategy(){
        sortContext = new SortContext(new SelectionSortStrategy());
        int[] input = new int[] {5, 4, 3, 2, 1};
        int[] result = sortContext.sorting(input);
        int[] expectedResult = new int[] {1, 2, 3, 4, 5};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }


    @Test
    void testTextBubbleSortStrategy(){
        sortContext = new SortContext(new BubbleSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextCountingSortStrategy(){
        sortContext = new SortContext(new CountingSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextInsertionSortStrategy(){
        sortContext = new SortContext(new InsertionSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextMergeSortStrategy(){
        sortContext = new SortContext(new MergeSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextQuickSortStrategy(){
        sortContext = new SortContext(new QuickSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextSelectionSortStrategy(){
        sortContext = new SortContext(new SelectionSortStrategy());
        String[] input = new String[] {"e", "d", "c", "b", "a"};
        String[] result = sortContext.sortingText(input);
        String[] expectedResult = new String[] {"a", "b", "c", "d", "e"};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }


    @Test
    void testObjectBubbleSortStrategy(){
        sortContext = new SortContext(new BubbleSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectBubbleSortStrategy(){
        sortContext = new SortContext(new BubbleSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testObjectCountingSortStrategy(){
        sortContext = new SortContext(new CountingSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectCountingSortStrategy(){
        sortContext = new SortContext(new CountingSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testObjectInsertionSortStrategy(){
        sortContext = new SortContext(new InsertionSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectInsertionSortStrategy(){
        sortContext = new SortContext(new InsertionSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testObjectMergeSortStrategy(){
        sortContext = new SortContext(new MergeSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectMergeSortStrategy(){
        sortContext = new SortContext(new MergeSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testObjectQuickSortStrategy(){
        sortContext = new SortContext(new QuickSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectQuickSortStrategy(){
        sortContext = new SortContext(new QuickSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testObjectSelectionSortStrategy(){
        sortContext = new SortContext(new SelectionSortStrategy());
        JSONObject object1 = new JSONObject();
        JSONObject object2 = new JSONObject();
        try{
            object1.put("name", "Filip");
            object1.put("age", 21);

            object2.put("name", "Michał");
            object2.put("age", 20);
        } catch (JSONException e){
            e.printStackTrace();
        }

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "age";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

    @Test
    void testTextObjectSelectionSortStrategy(){
        sortContext = new SortContext(new SelectionSortStrategy());
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

        JSONObject[] input = new JSONObject[] {object1, object2};
        String sortingAttribute = "name";
        JSONObject[] result = sortContext.sortingObject(input, sortingAttribute);
        JSONObject[] expectedResult = new JSONObject[] {object2, object1};
        Assertions.assertTrue(Arrays.equals(expectedResult, result));
    }

}