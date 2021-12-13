package pl.put.poznan.sortingMadness.rest;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingMadness;
import pl.put.poznan.sortingMadness.logic.SortingObjectMadness;
import pl.put.poznan.sortingMadness.logic.SortingTextMadness;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/{sorting_type}/")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    // example -> http://localhost:8080/insertion/?numbers=5,4,3,2,1,4,2,5,6
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> get(@PathVariable String sorting_type,
                              @RequestParam(value="numbers", defaultValue="") String[] numbers) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(numbers));

        SortingMadness sorter = new SortingMadness(sorting_type);
        logger.debug(sorter.getSorting_type());

        Instant start = Instant.now();
        int [] sorted_table = sorter.sort(numbers);
        if (numbers.equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        sorter.setSorted_list(sorted_table);
        sorter.setTime_elapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    // example -> http://localhost:8080/insertion/text/?strings=kota,ma,ala
    @RequestMapping(value="/text/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> getString(@PathVariable String sorting_type,
                                      @RequestParam(value="strings", defaultValue="") String[] strings) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(strings));

        SortingTextMadness sorter = new SortingTextMadness(sorting_type);
        logger.debug(sorter.getSorting_type());

        Instant start = Instant.now();
        String [] sorted_table = sorter.sort(strings);
        if (strings.equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        sorter.setSorted_list(sorted_table);
        sorter.setTimeElapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody SortingInput json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getData()));

        // silly in api with db
        SortingMadness sorter = new SortingMadness(json.getSortingType());

        int [] sorted_table;
        Instant start = Instant.now();
        sorted_table = sorter.sort(json.getData());
        if (json.getData().equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        sorter.setSorted_list(sorted_table);
        sorter.setTime_elapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    @RequestMapping(value = "/text/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> postText(@RequestBody SortingInput json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getData()));

        // silly in api with db
        SortingTextMadness sorter = new SortingTextMadness(json.getSortingType());

        String [] sorted_table;
        Instant start = Instant.now();
        sorted_table = sorter.sort(json.getData());
        if (json.getData().equals("") || sorted_table.length == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        sorter.setSorted_list(sorted_table);
        sorter.setTimeElapsed(time_elapsed);

        logger.debug(Arrays.toString(sorter.getSorted_list()));
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }

    @RequestMapping(value = "/object/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> postObject(@RequestBody SortingInputObject json) {

        logger.debug(json.getSortingType());
        logger.debug(new Gson().toJson(json.getData()));
        JSONObject data_array = new JSONObject(json);

        // silly in api with db
        SortingObjectMadness sorter = new SortingObjectMadness(data_array.get("sortingType").toString());

        JSONObject[] sorted_table;
        Instant start = Instant.now();

        JSONObject[] arr = new JSONObject[((JSONArray) data_array.get("data")).length()];
        for (int i = 0; i < ((JSONArray) data_array.get("data")).length(); i++) {
            JSONObject object = ((JSONArray) data_array.get("data")).getJSONObject(i);
            arr[i] = object;
        }

        sorted_table = sorter.sort(arr, data_array.get("sortingAttribute").toString());

        if (((JSONArray) data_array.get("data")).length() == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        List<JSONObject> arr2 = new ArrayList<JSONObject>();
        for(int i=0; i< sorted_table.length; i++){
            arr2.add(sorted_table[i]);
        }

        sorter.setSorted_list(arr2);
        sorter.setTimeElapsed(time_elapsed);

        logger.debug(sorter.getSorted_list().toString());
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(new Gson().toJson(sorter), HttpStatus.OK);
    }
}
