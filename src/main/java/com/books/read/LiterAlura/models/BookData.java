package com.books.read.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
		String title,
		Long id,
		List<AuthorData> authors,
		List<String> languages,
		@JsonAlias("download_count") Integer downloadCount
) {


}
