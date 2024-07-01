package com.books.read.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(
		String name,
		@JsonAlias("birth_year") Integer birthYear,
		@JsonAlias("death_year") Integer deathYear
) {
}
