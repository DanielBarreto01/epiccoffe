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

public class ManagerProduct {
	
	private String endpoint;
	private Product [] productList;
	
	public ManagerProduct() {
		endpoint = "https://6227bdb09fd6174ca812155b.mockapi.io/product";
		productList = new Product[1];
	}
	
	public Product[] getProducts() throws IOException, InterruptedException {
		Gson gson = new Gson();
		Product [] productList = new Product[1];
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				productList = gson.fromJson(response.body(), new TypeToken<Product[]>() {
		}.getType());
		return productList;
	}
	
	public boolean createProduct(Product product) throws IOException, InterruptedException {
		//if (person.getAge()>=18 ) { //&& !person.getFirstName().equals("")&& !person.getLastName().equals("") && !person.getDocumentNumber().equals("")
		Gson gson = new Gson();
        String body = gson.toJson(product);
        System.out.println();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return false;
    }
	
	public boolean updateProduct(int id, Product product) throws IOException, InterruptedException {
			Gson gson = new Gson();
			String body = gson.toJson(product);
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "/" + id))
					.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS))
					.PUT(HttpRequest.BodyPublishers.ofString(body)).build();
					HttpClient client = HttpClient.newHttpClient();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return true;
	}
	
	public void deleteProduct(int id) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "/" + id))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).DELETE()
				.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	}
	
	public void getProduct(int codeOfPerson) throws IOException, InterruptedException {
		Person[] personAux = new Person[1];
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "?CodOfPerson=" + codeOfPerson))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		productList = gson.fromJson(response.body(), new TypeToken<Product[]>() {
		}.getType());
	}
	
	public Product actualProduct(String codProduct, int codeOfPerson) throws IOException, InterruptedException, Exception {
		getProduct(codeOfPerson);
		for (int i = 0; i < productList.length; i++) {
			if (productList[i].getId() ==  Integer.parseInt(codProduct)) {
				return productList[i];
			}
		}
		throw new Exception();
	}
	
	public Product getProductId(int id) throws IOException, InterruptedException {
		 Gson gson = new Gson();
	     HttpRequest request = HttpRequest.newBuilder()
	              .uri(URI.create(endpoint + "/" + id))
	              .headers("Content-Type", "application/json")
	              .timeout(Duration.of(10, ChronoUnit.SECONDS))
	              .GET()
	              .build();
	            HttpClient client = HttpClient.newHttpClient();
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            return gson.fromJson(response.body(), Product.class);
	}
	
}
