package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingInput {
    @JsonProperty("data")
    private String[] data;

    @JsonProperty("sortingTypes")
    private Object sortingTypes;

    public SortingInput(@JsonProperty("data") String[] data, @JsonProperty("sortingTypes") Object sortingTypes) {
        this.sortingTypes = sortingTypes;
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public Object getSortingTypes() {
        return sortingTypes;
    }

    public void setSortingTypes(Object sortingTypes) {
        this.sortingTypes = sortingTypes;
    }
}
