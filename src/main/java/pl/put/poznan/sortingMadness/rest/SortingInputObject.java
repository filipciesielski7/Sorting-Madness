package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SortingInputObject {

    @JsonProperty("data")
    private Object data;

    @JsonProperty("sortingTypes")
    private Object sortingTypes;

    @JsonProperty("sortingAttribute")
    private String sortingAttribute;

    public SortingInputObject(@JsonProperty("data") Object data, @JsonProperty("sortingTypes") Object sortingTypes, @JsonProperty("sortingAttribute") String sortingAttribute) {
        this.sortingTypes = sortingTypes;
        this.data = data;
        this.sortingAttribute = sortingAttribute;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getSortingTypes() {
        return sortingTypes;
    }

    public void setSortingTypes(Object sortingTypes) {
        this.sortingTypes = sortingTypes;
    }

    public Object getSortingAttribute() {
        return sortingAttribute;
    }

    public void setSortingAttribute(String sortingAttribute) {
        this.sortingAttribute = sortingAttribute;
    }
}
