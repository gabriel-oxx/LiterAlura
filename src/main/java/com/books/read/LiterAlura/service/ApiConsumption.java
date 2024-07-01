package com.books.read.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ApiConsumption {

		public static String consumption(String text) throws URISyntaxException, IOException, InterruptedException, RuntimeException{
			// Declarando as variáveis antes de usá-las
			HttpClient client = null;
			HttpRequest request = null;
			HttpResponse<String> response = null;

			try {
				// Inicializando as variáveis
				client = HttpClient.newBuilder()
						.connectTimeout(Duration.ofSeconds(40))
						.build();

				String BASE_URL = "https://gutendex.com/books/?search=";
				String url = BASE_URL + text.replace(" ", "+");

				request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.build();

				response = client.send(request, HttpResponse.BodyHandlers.ofString());
				return response.body();
			} catch (IllegalArgumentException | IOException | InterruptedException error) {
				System.err.println("Parece que você inseriu algum caractere indevido aqui " + error.getMessage());
				// Definindo um valor padrão a ser retornado em caso de exceção
				return "Erro ao consumir a API";
			} finally {
				// Garantindo que o cliente HTTP seja fechado corretamente
				if (client!= null) {
					client.close();
				}
			}
		}



}
