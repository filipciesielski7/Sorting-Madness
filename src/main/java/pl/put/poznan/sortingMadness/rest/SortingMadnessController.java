package pl.put.poznan.sortingMadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingMadness;

import java.util.Arrays;


@RestController
@RequestMapping("/{number_array}")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String number_array,
                              @RequestParam(value="numbers", defaultValue="upper,escape") String[] numbers) {

        // log the parameters
        logger.debug(number_array);
        logger.debug(Arrays.toString(numbers));

        // perform sorting, you should run your logic here, below is just a silly example
        SortingMadness sorter = new SortingMadness(numbers);
        return sorter.sort(number_array);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String number_array,
                      @RequestBody String[] numbers) {

        // log the parameters
        logger.debug(number_array);
        logger.debug(Arrays.toString(numbers));

        // perform sorting, you should run your logic here, below is just a silly example
        SortingMadness sorter = new SortingMadness(numbers);
        return sorter.sort(number_array);
    }



}


