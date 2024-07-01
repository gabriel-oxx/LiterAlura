package com.books.read.LiterAlura.service;

public interface DataConverterI {
	public  <T> T getData(String json, Class<T> dataClass);
}
