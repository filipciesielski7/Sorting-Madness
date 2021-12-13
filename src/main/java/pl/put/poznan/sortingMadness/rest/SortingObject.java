package pl.put.poznan.sortingMadness.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.put.poznan.sortingMadness.logic.Person;

public class SortingObject {

    @JsonProperty("sortingType")
    private String sortingType;

    @JsonProperty("data")
    private Person[] data;

    @JsonProperty("sortingAttribute")
    private String sortingAttribute;

    public SortingObject(@JsonProperty("sortingType") String sortingType, @JsonProperty("data") Person[] data, @JsonProperty("sortingAttribute") String sortingAttribute) {
        this.sortingType = sortingType;
        this.data = data;
        this.sortingAttribute = sortingAttribute;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }

    public Person[] getData() {
        return data;
    }

    public void setData(Person[] data) {
        this.data = data;
    }

    public String getSortingAttribute() {
        return sortingAttribute;
    }

    public void setSortingAttribute(String sortingAttribute) {
        this.sortingAttribute = sortingAttribute;
    }
}
