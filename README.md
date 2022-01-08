<h1 align="center">
    Sorting Madness 7️⃣
</h1>

![ci](https://github.com/filipciesielski7/Sorting-Madness/actions/workflows/ci.yml/badge.svg) ![test](https://github.com/filipciesielski7/Sorting-Madness/actions/workflows/test.yml/badge.svg)

_Also available in: [Polski](README.pl.md)_

## About 

Sorting-Madness project for Software Engineering at Poznan University of Technology. The application implements 6 various sorting algorithms which can be used to sort different data sets using REST API and compare their sort times. Numeric data is sorted by standard, and text data - lexicographically. Strategy pattern was also implemented to select specific sorting method at runtime, as you can se on the [UML](https://en.wikipedia.org/wiki/Unified_Modeling_Language) diagram below.

![UML](./src/main/resources/Sorting-Madness-UML.png)

The main goal of this project was to get to know [Scrum](https://en.wikipedia.org/wiki/Scrum_(software_development)) project management methodology ([Sprint](https://docs.google.com/spreadsheets/d/e/2PACX-1vTn6j3M8pmGEzrsQk8mXse7lVHUdhYWkfxbkQiYI23rBtwM4N3bWw0qtupW-gesfCkcYasnZ-eEXl-F/pubhtml)
, [Product Backlog](https://docs.google.com/spreadsheets/d/1MwBEK283qNdv1wkT7OfIPgs4_kbdy4gXljwIPXqAN7Y/edit#gid=1176682582)
) and implement REST API [Java](https://www.java.com/) [Spring Boot](https://spring.io/projects/spring-boot) application with [Maven](https://maven.apache.org/) which can be used by GET and POST requests. Additionally, [Javadoc](https://en.wikipedia.org/wiki/Javadoc) was created, mentioned [Strategy Pattern](https://en.wikipedia.org/wiki/Strategy_pattern) implemented and [JUnit](https://junit.org/junit5/) tests conducted.

## Running the application

The project is a standard Maven project. To run it from the command line, type `mvn spring-boot:run`, and then use http://localhost:8080 address with POST or GET requests to sort the data.

You can also import the project to your IDE of choice as you would with any
Maven project or just use the deployed version https://sorting-madness.herokuapp.com/.

## How to use?

### GET Request

```
http://localhost:8080/<list of sorting algorithms>/?numbers=<list of integers>
http://localhost:8080/insertion,bubble,merge/?numbers=5,4,3,2,1,4,2,5,6
```

```
http://localhost:8080/text/<list of sorting algorithms>/?strings=<list of strings>
http://localhost:8080/text/insertion,bubble,merge/?strings=kota,ma,ala
```
### POST Request

```json
{
  "sortingTypes": ["insertion", "bubble", "merge"],
  "data": [5, 4, 3, 2, 1]
}
```

```json
 {
  "sortingTypes": ["quick", "bubble", "insertion"],
  "data": ["d", "e", "c", "b", "a"]
}
```

```json
 {
  "sortingTypes": ["bubble", "quick", "insertion"],
  "data": [
    {
      "a": 1,
      "b": 5,
      "c": "c"
    },
    {
      "a": 3,
      "b": 4,
      "c": "a"
    },
    {
      "a": 6,
      "b": 2,
      "c": "b"
    }
  ],
  "sortingAttribute": "a"
}
```
