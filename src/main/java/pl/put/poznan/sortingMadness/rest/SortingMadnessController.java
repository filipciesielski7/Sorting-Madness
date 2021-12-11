package pl.put.poznan.sortingMadness.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingMadness;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

// example -> http://localhost:8080/insertion/?numbers=5,4,3,2,1,4,2,5,6
@RestController
@RequestMapping("/{sorting_type}/")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);
    private SortingMadness result;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> get(@PathVariable String sorting_type,
                              @RequestParam(value="numbers", defaultValue="") String[] numbers) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(numbers));

        // SortingMadness sorter = new SortingMadness(sorting_type);
        SortingMadness sorter = new SortingMadness(sorting_type);
        logger.debug(sorter.getSorting_type());
        Instant start = Instant.now();
        int [] sorted_table = sorter.sort(numbers);
        if (numbers.equals("") || sorted_table.length == 0) {
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        // String result = sorter.sort(numbers);
        // StringResponse stringResponse = new StringResponse(sorter.sort(numbers));
        result = new SortingMadness(sorting_type, sorted_table, timeElapsed);
        logger.debug(Arrays.toString(result.getSorted_list()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody SortingInput json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getNumbers()));


        // silly in api with db
        SortingMadness sorter = new SortingMadness(json.getSortingType());


        int [] sorted_table;
        Instant start = Instant.now();
        sorted_table = sorter.sort(json.getNumbers());
        if (json.getNumbers().equals("") || sorted_table.length == 0) {
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        result = new SortingMadness(json.getSortingType(), sorted_table, timeElapsed);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
