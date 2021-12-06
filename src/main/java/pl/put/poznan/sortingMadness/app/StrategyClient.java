package pl.put.poznan.sortingMadness.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.sortingMadness.rest"})
public class StrategyClient {

    public static void main(String[] args) {
        SpringApplication.run(StrategyClient.class, args);
    }
}
