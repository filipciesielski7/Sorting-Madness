package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingInput {
    @JsonProperty("data")
    private String[] data;

    @JsonProperty("sortingType")
    private String sortingType;

    public SortingInput(@JsonProperty("data") String[] data, @JsonProperty("sortingType") String sortingType) {
        this.sortingType = sortingType;
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }
}
