package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingInputObject {

    @JsonProperty("data")
    private Object data;

    @JsonProperty("sortingType")
    private String sortingType;

    @JsonProperty("sortingAttribute")
    private String sortingAttribute;

    public SortingInputObject(@JsonProperty("data") Object data, @JsonProperty("sortingType") String sortingType, @JsonProperty("sortingAttribute") String sortingAttribute) {
        this.sortingType = sortingType;
        this.data = data;
        this.sortingAttribute = sortingAttribute;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }

    public String getSortingAttribute() {
        return sortingAttribute;
    }

    public void setSortingAttribute(String sortingAttribute) {
        this.sortingAttribute = sortingAttribute;
    }
}
