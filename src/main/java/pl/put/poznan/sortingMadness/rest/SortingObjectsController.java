package pl.put.poznan.sortingMadness.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.sortingMadness.logic.Person;
import pl.put.poznan.sortingMadness.logic.SortingObjectMadness;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class SortingObjectsController {


    private static final Logger logger = LoggerFactory.getLogger(SortingObjectsController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Object> post(@RequestBody SortingObject json) {

        logger.debug(json.getSortingType());
        logger.debug(Arrays.toString(json.getData()));
        logger.debug(json.getSortingAttribute());

        // silly in api with db
        SortingObjectMadness sorter = new SortingObjectMadness(json.getSortingType());

        List<Person> sorted_table = new ArrayList<Person>(Arrays.asList(json.getData()));
        logger.debug(sorted_table.get(0).getFirstName());
        Instant start = Instant.now();

        sorter.setSortingAttribute(json.getSortingAttribute());

        sorted_table = sorter.sort(sorted_table, json.getSortingAttribute());
        if (json.getData().equals("") || sorted_table.size() == 0) {
            logger.info("Error occurred");
            return new ResponseEntity<>("Error! Bad Input", HttpStatus.BAD_REQUEST);
        }
        Instant finish = Instant.now();
        long time_elapsed = Duration.between(start, finish).toNanos() / 10000;

        sorter.setSorted_list(sorted_table);
        sorter.setTime_elapsed(time_elapsed);

        String listString = sorted_table.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

        logger.debug(listString);
        logger.info("Measured time: " + time_elapsed);

        return new ResponseEntity<>(sorter, HttpStatus.OK);
    }
}
