package pl.put.poznan.sortingMadness.rest;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingNumberMadness;
import pl.put.poznan.sortingMadness.logic.SortingObjectMadness;
import pl.put.poznan.sortingMadness.logic.SortingTextMadness;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    // example -> http://localhost:8080/insertion,bubble,merge/?numbers=5,4,3,2,1,4,2,5,6
    @RequestMapping(value = "/{sorting_types}/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> get(@PathVariable String[] sorting_types,
                              @RequestParam(value="numbers", defaultValue="") String[] numbers) {

        if (numbers.length == 0) {
            logger.error("Error occurred - numbers list is empty");
            return new ResponseEntity<>("Error! Bad input, numbers list can't be empty", HttpStatus.BAD_REQUEST);
        }

        if (sorting_types.length == 0){
            logger.error("Error occurred - sorting types array is empty");
            return new ResponseEntity<>("Error! Bad input, sorting types array can't be empty", HttpStatus.BAD_REQUEST);
        }

        logger.info("Sorting types: " + Arrays.toString(sorting_types));
        logger.info("Numbers: " + Arrays.toString(numbers));

        int[] sortedData = new int[0];
        long[] timeMeasurements = new long[sorting_types.length];

        int index = 0;
        for (String sorting_type : sorting_types){
            SortingNumberMadness sorter = new SortingNumberMadness(sorting_type);

            Instant start = Instant.now();

            try{
                sortedData = sorter.sort(numbers);
            }catch (Exception e){
                logger.error("Error occured - " + e.toString());
                return new ResponseEntity<>("Error! Bad input, " + e.toString(), HttpStatus.BAD_REQUEST);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            timeMeasurements[index++] = timeElapsed;
        }

        if (sortedData.length == 0) {
            logger.error("Error occurred");
            return new ResponseEntity<>("Error! Something went wrong with data sorting", HttpStatus.BAD_REQUEST);
        }

        List<Integer> sortedData2 = new ArrayList<Integer>();
        for(int i = 0; i < sortedData.length; i++){
            sortedData2.add(sortedData[i]);
        }

        FinalObject finalObject = new FinalObject(sorting_types, sortedData2,  timeMeasurements);

        logger.info("Sorted number list: " + finalObject.getSorted_number_list().toString());
        logger.info("Measured times: " + Arrays.toString(finalObject.getTime_elapsed_list()));

        JSONObject finalObj = new JSONObject(finalObject);
        return new ResponseEntity<>(finalObj.toString(), HttpStatus.OK);
    }

    // example -> http://localhost:8080/text/insertion,bubble,merge/?strings=kota,ma,ala
    @RequestMapping(value="/text/{sorting_types}/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getString(@PathVariable String[] sorting_types,
                                      @RequestParam(value="strings", defaultValue="") String[] strings) {

        if (strings.length == 0) {
            logger.error("Error occurred - strings list is empty");
            return new ResponseEntity<>("Error! Bad input, strings list can't be empty", HttpStatus.BAD_REQUEST);
        }

        if (sorting_types.length == 0){
            logger.error("Error occurred - sorting types array is empty");
            return new ResponseEntity<>("Error! Bad input, sorting types array can't be empty", HttpStatus.BAD_REQUEST);
        }

        logger.info("Sorting types: " + Arrays.toString(sorting_types));
        logger.info("Strings: " + Arrays.toString(strings));

        String[] sortedData = new String[0];
        long[] timeMeasurements = new long[sorting_types.length];

        int index = 0;
        for (String sorting_type : sorting_types){
            SortingTextMadness sorter = new SortingTextMadness(sorting_type);

            Instant start = Instant.now();

            try{
                sortedData = sorter.sort(strings);
            }catch (Exception e){
                logger.error("Error occured - " + e.toString());
                return new ResponseEntity<>("Error! Bad input, " + e.toString(), HttpStatus.BAD_REQUEST);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            timeMeasurements[index++] = timeElapsed;
        }

        if (sortedData.length == 0) {
            logger.error("Error occurred");
            return new ResponseEntity<>("Error! Something went wrong with data sorting", HttpStatus.BAD_REQUEST);
        }

        List<String> sortedData2 = new ArrayList<String>();
        for(int i = 0; i < sortedData.length; i++){
            sortedData2.add(sortedData[i]);
        }

        FinalObject finalObject = new FinalObject(sorting_types, timeMeasurements, sortedData2);

        logger.info("Sorted string list: " + finalObject.getSorted_text_list().toString());
        logger.info("Measured times: " + Arrays.toString(finalObject.getTime_elapsed_list()));

        JSONObject finalObj = new JSONObject(finalObject);
        return new ResponseEntity<>(finalObj.toString(), HttpStatus.OK);
    }

    /*
         example ->
         http://localhost:8080/
         {
            "sortingTypes": ["insertion", "bubble", "merge"],
            "data": [5, 4, 3, 2, 1]
         }
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody SortingInput json) {

        JSONObject jsonObject = new JSONObject(json);
        if (((JSONArray) jsonObject.get("data")).length() == 0) {
            logger.error("Error occurred - data array is empty");
            return new ResponseEntity<>("Error! Bad input, data array can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (((JSONArray) jsonObject.get("sortingTypes")).length() == 0) {
            logger.error("Error occurred - sorting types array is empty");
            return new ResponseEntity<>("Error! Bad input, sorting types array can't be empty", HttpStatus.BAD_REQUEST);
        }

        logger.info("Sorting types: " + new Gson().toJson(json.getSortingTypes()));
        logger.info("Data: " + new Gson().toJson(json.getData()));

        int[] sortedData = new int[0];
        long[] timeMeasurements = new long[((JSONArray) jsonObject.get("sortingTypes")).length()];

        int index = 0;
        for (Object sorting_type : ((JSONArray) jsonObject.get("sortingTypes"))) {
            SortingNumberMadness sorter = new SortingNumberMadness(sorting_type.toString());

            Instant start = Instant.now();

            try{
                sortedData = sorter.sort(json.getData());
            }catch (Exception e){
                logger.error("Error occured - " + e.toString());
                return new ResponseEntity<>("Error! Bad input, " + e.toString(), HttpStatus.BAD_REQUEST);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            timeMeasurements[index++] = timeElapsed;
        }

        if (sortedData.length == 0) {
            logger.error("Error occurred");
            return new ResponseEntity<>("Error! Something went wrong with data sorting", HttpStatus.BAD_REQUEST);
        }

        List<Integer> sortedData2 = new ArrayList<Integer>();
        for(int i = 0; i < sortedData.length; i++){
            sortedData2.add(sortedData[i]);
        }

        FinalObject finalObject = new FinalObject(json.getSortingTypes(), timeMeasurements, sortedData2);

        logger.info("Sorted number list: " + finalObject.getSorted_number_list().toString());
        logger.info("Measured times: " + Arrays.toString(finalObject.getTime_elapsed_list()));

        JSONObject finalObj = new JSONObject(finalObject);
        return new ResponseEntity<>(finalObj.toString(), HttpStatus.OK);
    }

    /*
         example ->
         http://localhost:8080/text/
         {
            "sortingTypes": ["quick", "bubble", "insertion"],
            "data": ["d", "e", "c", "b", "a"]
         }
     */
    @RequestMapping(value = "/text/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> postText(@RequestBody SortingInput json) {

        JSONObject jsonObject = new JSONObject(json);
        if (((JSONArray) jsonObject.get("data")).length() == 0) {
            logger.error("Error occurred - data array is empty");
            return new ResponseEntity<>("Error! Bad input, data array can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (((JSONArray) jsonObject.get("sortingTypes")).length() == 0) {
            logger.error("Error occurred - sorting types array is empty");
            return new ResponseEntity<>("Error! Bad input, sorting types array can't be empty", HttpStatus.BAD_REQUEST);
        }

        logger.info("Sorting types: " + new Gson().toJson(json.getSortingTypes()));
        logger.info("Data: " + new Gson().toJson(json.getData()));

        String[] sortedData = new String[0];
        long[] timeMeasurements = new long[((JSONArray) jsonObject.get("sortingTypes")).length()];

        int index = 0;
        for (Object sorting_type : ((JSONArray) jsonObject.get("sortingTypes"))) {
            SortingTextMadness sorter = new SortingTextMadness(sorting_type.toString());

            Instant start = Instant.now();

            try{
                sortedData = sorter.sort(json.getData());
            }catch (Exception e){
                logger.error("Error occured - " + e.toString());
                return new ResponseEntity<>("Error! Bad input, " + e.toString(), HttpStatus.BAD_REQUEST);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            timeMeasurements[index++] = timeElapsed;
        }

        if (sortedData.length == 0) {
            logger.error("Error occurred");
            return new ResponseEntity<>("Error! Something went wrong with data sorting", HttpStatus.BAD_REQUEST);
        }

        List<String> sortedData2 = new ArrayList<String>();
        for(int i = 0; i < sortedData.length; i++){
            sortedData2.add(sortedData[i]);
        }

        FinalObject finalObject = new FinalObject(json.getSortingTypes(), sortedData2, timeMeasurements);

        logger.info("Sorted text list: " + finalObject.getSorted_text_list().toString());
        logger.info("Measured times: " + Arrays.toString(finalObject.getTime_elapsed_list()));

        JSONObject finalObj = new JSONObject(finalObject);
        return new ResponseEntity<>(finalObj.toString(), HttpStatus.OK);
    }

    /*
         example ->
         http://localhost:8080/object/
            {
                "sortingTypes": ["bubble", "quick", "insertion"],
                    "data": [
                {
                    "a": 1,
                        "b": 5,
                        "c": "c"
                },
                {
                    "a": 3,
                        "b": 4,
                        "c": "a"
                },
                {
                    "a": 6,
                        "b": 2,
                        "c": "b"
                }
            ],
                "sortingAttribute": "a"
            }
    */
    @RequestMapping(value = "/object/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody SortingInputObject json) {

        JSONObject jsonObject = new JSONObject(json);
        if (((JSONArray) jsonObject.get("data")).length() == 0) {
            logger.error("Error occurred - data array is empty");
            return new ResponseEntity<>("Error! Bad input, data array can't be empty", HttpStatus.BAD_REQUEST);
        }
        if (((JSONArray) jsonObject.get("sortingTypes")).length() == 0) {
            logger.error("Error occurred - sorting types array is empty");
            return new ResponseEntity<>("Error! Bad input, sorting types array can't be empty", HttpStatus.BAD_REQUEST);
        }

        logger.info("Sorting types: " + new Gson().toJson(json.getSortingTypes()));
        logger.info("Data: " + new Gson().toJson(json.getData()));
        logger.info("Sorting attribute: " + new Gson().toJson(json.getSortingAttribute()));

        JSONObject[] sortedData = new JSONObject[0];
        long[] timeMeasurements = new long[((JSONArray) jsonObject.get("sortingTypes")).length()];

        JSONObject[] data = new JSONObject[((JSONArray) jsonObject.get("data")).length()];
        for (int i = 0; i < ((JSONArray) jsonObject.get("data")).length(); i++) {
            JSONObject object = ((JSONArray) jsonObject.get("data")).getJSONObject(i);
            data[i] = object;
        }

        int index = 0;
        for (Object sorting_type : ((JSONArray) jsonObject.get("sortingTypes"))){

            SortingObjectMadness sorter = new SortingObjectMadness(sorting_type.toString());

            Instant start = Instant.now();

            try{
                sortedData = sorter.sort(data, jsonObject.get("sortingAttribute").toString());
            }catch (Exception e){
                logger.error("Error occured - " + e.toString());
                return new ResponseEntity<>("Error! Bad input, " + e.toString(), HttpStatus.BAD_REQUEST);
            }

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            timeMeasurements[index++] = timeElapsed;
        }

        if (sortedData.length == 0) {
            logger.error("Error occurred");
            return new ResponseEntity<>("Error! Something went wrong with data sorting", HttpStatus.BAD_REQUEST);
        }

        List<JSONObject> sortedData2 = new ArrayList<JSONObject>();
        for(int i = 0; i < sortedData.length; i++){
            sortedData2.add(sortedData[i]);
        }

        FinalObject finalObject = new FinalObject(json.getSortingTypes(), json.getSortingAttribute(), sortedData2, timeMeasurements);

        logger.info("Sorted data: " + finalObject.getSorted_list().toString());
        logger.info("Measured times: " + Arrays.toString(finalObject.getTime_elapsed_list()));

        JSONObject finalObj = new JSONObject(finalObject);
        return new ResponseEntity<>(finalObj.toString(), HttpStatus.OK);
    }
}
