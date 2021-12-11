package pl.put.poznan.sortingMadness.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This is just an example to show that the logic should be outside the REST service.
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.sortingMadness.rest"})
public class StrategyClient {


//    private String sorting_type;
//    private int[] sorted_list;
//    private long timeElapsed;
//    private long sda;
//
//    public StrategyClient() {
//    }
//
//    public StrategyClient(String sorting_type) {
//        this.sorting_type = sorting_type;
//    }
//
//    public StrategyClient(String sorting_type, int[] sorted_list, long timeElapsed){
//        this.sorting_type = sorting_type;
//        this.sorted_list = sorted_list;
//        this.timeElapsed = timeElapsed;
//    }
//
//    public int[] sort(String[] data_array){
//
//        int [] data = Stream.of(data_array).mapToInt(Integer::parseInt).toArray();
//        SortContext context;
//
//        if(sorting_type.toUpperCase().equals("BUBBLE")){
//            context = new SortContext(new BubbleSortStrategy());
//            return context.sorting(data);
//        }
//
//        else if(sorting_type.toUpperCase().equals("MERGE")) {
//            context = new SortContext(new MergeSortStrategy());
//            return context.sorting(data);
//        }
//
//        else if(sorting_type.toUpperCase().equals("COUNTING")) {
//            context = new SortContext(new CountingSortStrategy());
//            return context.sorting(data);
//        }
//
//        else if(sorting_type.toUpperCase().equals("INSERTION")) {
//            context = new SortContext(new InsertionSortStrategy());
//            return context.sorting(data);
//        }
//
//        else if(sorting_type.toUpperCase().equals("QUICK")) {
//            context = new SortContext(new QuickSortStrategy());
//            return context.sorting(data);
//        }
//
//        else if(sorting_type.toUpperCase().equals("SELECTION")) {
//            context = new SortContext(new SelectionSortStrategy());
//            return context.sorting(data);
//        }
//
//        return data;
//    }
//
//    public String getSorting_type() {
//        return sorting_type;
//    }
//
//    public void setSorting_type(String sorting_type) {
//        this.sorting_type = sorting_type;
//    }
//
//    public int[] getSorted_list() {
//        return sorted_list;
//    }
//
//    public void setSorted_list(int[] sorted_list) {
//        this.sorted_list = sorted_list;
//    }
//
//    public long getTimeElapsed() {
//        return timeElapsed;
//    }
//
//    public void setTimeElapsed(long timeElapsed) {
//        this.timeElapsed = timeElapsed;
//    }

    public static void main(String[] args) {
        SpringApplication.run(StrategyClient.class, args);


    }
}
