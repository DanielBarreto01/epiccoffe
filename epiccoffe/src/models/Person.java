package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;


public class Person {
	
	protected int id;
	protected String firstName;
	protected String lastName;	
	protected String typeDocument;
	protected String documentNumber;
	protected String user;
	protected String password;
	protected int age;
	protected GregorianCalendar dateOfBirth;
	protected String typeOfPerson;
	
	public Person(String firstName, String lastName, String typeDocument, String documentNumber, String user,
			String password, GregorianCalendar dateOfBirth, String typeOfPerson) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeDocument = typeDocument;
		this.documentNumber = documentNumber;
		this.user = user;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.typeOfPerson = typeOfPerson;
		calculateAge();
	}
	
	private LocalDate convertToLocalDate(GregorianCalendar dateToConvert) {
		return dateToConvert.toZonedDateTime().toLocalDate();
	}
	
	public void calculateAge() {
	age = (int) ChronoUnit.YEARS.between(convertToLocalDate(dateOfBirth), convertToLocalDate(new GregorianCalendar()));
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public String getTypeOfPerson() {
		return typeOfPerson;
	}

	@Override
	public String toString() {
		return "Nombre: "+ firstName + "codigo: " + documentNumber;
	}
	
}
