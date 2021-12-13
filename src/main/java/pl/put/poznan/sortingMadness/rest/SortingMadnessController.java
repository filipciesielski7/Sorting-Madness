package pl.put.poznan.sortingMadness.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingMadness;
import pl.put.poznan.sortingMadness.logic.SortingTextMadness;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;


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
}
