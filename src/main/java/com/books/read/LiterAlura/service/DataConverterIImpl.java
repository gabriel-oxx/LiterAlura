package com.books.read.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverterIImpl implements DataConverterI {
	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * @param json
	 * @param dataClass
	 * @param <T>
	 * @return
	 */
	@Override
	public <T> T getData(String json, Class<T> dataClass) {
		String message = "Opa, temos uma exceção aqui.";
		try {
			return mapper.readValue(json, dataClass);
		} catch (JsonMappingException error) {
			throw new RuntimeException(message + error);
		} catch (JsonProcessingException error) {
			throw new RuntimeException(message + error);
		}
	}


}
