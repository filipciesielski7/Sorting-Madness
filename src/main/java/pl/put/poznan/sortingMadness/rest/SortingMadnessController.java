package pl.put.poznan.sortingMadness.rest;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
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

    // example -> http://localhost:8080/insertion/?numbers=5,4,3,2,1,4,2,5,6
    @RequestMapping(value = "/{sorting_type}/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> get(@PathVariable String sorting_type,
                              @RequestParam(value="numbers", defaultValue="") String[] numbers) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(numbers));

        SortingNumberMadness sorter = new SortingNumberMadness(sorting_type);

        Instant start = Instant.now();
        int [] sorted_table = sorter.sort(numbers);
        if (numbers.equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toMillis();

        sorter.setSorted_list(sorted_table);
        sorter.setTime_elapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    // example -> http://localhost:8080/text/insertion/?strings=kota,ma,ala
    @RequestMapping(value="/text/{sorting_type}/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getString(@PathVariable String sorting_type,
                                      @RequestParam(value="strings", defaultValue="") String[] strings) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(strings));

        SortingTextMadness sorter = new SortingTextMadness(sorting_type);

        Instant start = Instant.now();
        String [] sorted_table = sorter.sort(strings);
        if (strings.equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toMillis();

        sorter.setSorted_list(sorted_table);
        sorter.setTimeElapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    /*
         example ->
         http://localhost:8080/
         {
            "sortingType": "bubble",
            "data": [5,4,3,2,1]
         }
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody SortingInput json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getData()));

        SortingNumberMadness sorter = new SortingNumberMadness(json.getSortingType());

        int [] sorted_table;
        Instant start = Instant.now();
        sorted_table = sorter.sort(json.getData());
        if (json.getData().equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toMillis();

        sorter.setSorted_list(sorted_table);
        sorter.setTime_elapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    /*
         example ->
         http://localhost:8080/text/
         {
            "sortingType": "insertion",
            "data": ["d", "e","c", "b", "a"]
         }
     */
    @RequestMapping(value = "/text/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> postText(@RequestBody SortingInput json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getData()));

        SortingTextMadness sorter = new SortingTextMadness(json.getSortingType());

        String [] sorted_table;
        Instant start = Instant.now();
        sorted_table = sorter.sort(json.getData());
        if (json.getData().equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toMillis();

        sorter.setSorted_list(sorted_table);
        sorter.setTimeElapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
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
