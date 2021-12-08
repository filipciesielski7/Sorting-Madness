package pl.put.poznan.sortingMadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingMadness.logic.SortingMadness;

import java.util.Arrays;

// example -> http://localhost:8080/insertion/?numbers=5,4,3,2,1,4,2,5,6
@RestController
@RequestMapping("/{sorting_type}/")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String sorting_type,
                       @RequestParam(value="numbers", defaultValue="") String[] numbers) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(numbers));

        SortingMadness sorter = new SortingMadness(sorting_type);
        return sorter.sort(numbers);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String sorting_type,
                      @RequestBody String[] numbers) {

        logger.debug(sorting_type);
        logger.debug(Arrays.toString(numbers));

        SortingMadness sorter = new SortingMadness(sorting_type);
        return sorter.sort(numbers);
    }
}
