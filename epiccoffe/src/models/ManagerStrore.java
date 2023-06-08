package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ManagerStrore {
	private String endPoint;
	
	
	public ManagerStrore() {
		endPoint = "https://6227bdb09fd6174ca812155b.mockapi.io/store";
	}
	
	public boolean createStrore(Store store) throws IOException, InterruptedException {
			Gson gson = new Gson();
			String body = gson.toJson(store);
			System.out.println();
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint))
					.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS))
					.POST(HttpRequest.BodyPublishers.ofString(body)).build();
					HttpClient client = HttpClient.newHttpClient();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return true;
	}
	
	public Store[] getProducts() throws IOException, InterruptedException {
		Gson gson = new Gson();
		Store [] productList = new Store[1];
				HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endPoint))
				.headers("Content-Type", "application/json")
				.timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				productList = gson.fromJson(response.body(), new TypeToken<Store[]>() {
		}.getType());
		return productList;
	}
	
	public void deleteStore(int id) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endPoint + "/" + id))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).DELETE()
				.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	}
}
