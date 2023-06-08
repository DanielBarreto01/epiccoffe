package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ManagerPerson {
	private Person personList[];
	private String endpoint;

	public ManagerPerson() {
		personList = new Person[0];
		endpoint = "https://6227bdb09fd6174ca812155b.mockapi.io/epiccoffe";
	}

	public boolean createPerson(Person person) throws IOException, InterruptedException {
		if (person.getAge() >= 18) { // && !person.getFirstName().equals("")&& !person.getLastName().equals("") &&						// !person.getDocumentNumber().equals("")
			Gson gson = new Gson();
			String body = gson.toJson(person);
			System.out.println();
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint))
					.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS))
					.POST(HttpRequest.BodyPublishers.ofString(body)).build();
					HttpClient client = HttpClient.newHttpClient();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return true;
		}
		return false;
	}

	public boolean updatePerson(int id, Person person) throws IOException, InterruptedException {
		if (person.getAge() >= 18) {
			Gson gson = new Gson();
			String body = gson.toJson(person);
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "/" + id))
					.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS))
					.PUT(HttpRequest.BodyPublishers.ofString(body)).build();
					HttpClient client = HttpClient.newHttpClient();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return true;
		} else {
			return false;
		}
	}

	public void getPersons() throws IOException, InterruptedException {
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(endpoint))
				.headers("Content-Type", "application/json")
				.timeout(Duration.of(10, ChronoUnit.SECONDS))
				.GET()
				.build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		personList = gson.fromJson(response.body(), new TypeToken<Person[]>() {
		}.getType());
	}
	/*
	 * public String[] covertToString(String name) throws IOException,
	 * InterruptedException { HashSet<Person> listPerson = new HashSet<>();
	 * personList = getPerson("?firstName=", name); Person[] listAux =
	 * getPerson("?lastName", name); String[] listPersons = new
	 * String[personList.length + listAux.length]; for (int i = 0; i <
	 * personList.length; i++) { for (int j = 0; j < listAux.length; j++) {
	 * listPerson.add(listAux[i]); } listPerson.add(personList[i]); } return
	 * eliminateNull(listPerson);
	 * 
	 * }
	 * 
	 * public String[] eliminateNull(HashSet<Person> list) { int count = 0; Person[]
	 * personAux= new Person[list.size()]; String [] aux = new String[list.size()];
	 * for (Person person : list) { aux[count] = person + ""; personAux[count] =
	 * person; count ++; } personList = personAux; return aux; }
	 */

	public void deletePerson(String id) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "/" + id))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).DELETE()
				.build();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	}

	public Person[] getPerson(String parameter, String name) throws IOException, InterruptedException {
		Person[] personAux = new Person[1];
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + parameter + name))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		personAux = gson.fromJson(response.body(), new TypeToken<Person[]>() {
		}.getType());
		return personAux;
	}

	public Person getPersonDocument(String document) throws IOException, InterruptedException, Exception {
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "?documentNumber=" + document))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		personList = gson.fromJson(response.body(), new TypeToken<Person[]>() {
		}.getType());
		if (personList.length == 0) {
			throw new Exception();
		}
		return personList[0];
	}
	
	public Person getPersonForDocument(String document) throws IOException, InterruptedException {
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "?documentNumber=" + document))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		personList = gson.fromJson(response.body(), new TypeToken<Person[]>() {
		}.getType());
		if (personList.length == 0) {
			return null;
		}
		return personList[0];
	}
	
	public Person getPersonUser(String user) throws IOException, InterruptedException {
		Gson gson = new Gson();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endpoint + "?user=" + user))
				.headers("Content-Type", "application/json").timeout(Duration.of(10, ChronoUnit.SECONDS)).GET().build();
				HttpClient client = HttpClient.newHttpClient();
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		personList = gson.fromJson(response.body(), new TypeToken<Person[]>() { }.getType());

		if (personList.length == 0) {
			return null;
		}
		return personList[0];
	}
	
	public Person[] getShowPersons() throws IOException, InterruptedException {
		getPersons();
		return personList;
	}
	
	public Person validate (String user, String password) throws IOException, InterruptedException {
		getPersons();
		for (Person person : personList) {
			if (person.getUser().equals(user) && person.getPassword().equals(password)) {
				return person;
			}
		}
		return null;
	}
	
	/*
	 * public static void main(String[] args) { ManagerPerson m = new
	 * ManagerPerson(); ManagerProduct n = new ManagerProduct(); m.create();
	 * n.create();
	 */

}
