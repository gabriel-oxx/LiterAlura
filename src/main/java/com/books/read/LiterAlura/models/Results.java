package com.books.read.LiterAlura.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(List<BookData> results) {
}
