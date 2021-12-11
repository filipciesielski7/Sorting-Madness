package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingInput {
    @JsonProperty("numbers")
    private String[] numbers;

    @JsonProperty("sortingType")
    private String sortingType;

    public SortingInput(@JsonProperty("numbers") String[] numbers, @JsonProperty("sortingType") String sortingType) {
        this.sortingType = sortingType;
        this.numbers = numbers;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }
}
