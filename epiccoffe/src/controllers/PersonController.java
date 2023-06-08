package controllers;

import java.io.IOException;
import java.util.GregorianCalendar;

import exceptions.RepeatedDocumentNumberException;
import exceptions.RepeatedUserException;
import models.ManagerPerson;
import models.Person;

public class PersonController {
	
	private ManagerPerson managerPerson;
	private static Person actualPerson;

	public PersonController() {
		managerPerson = new ManagerPerson();
	}
	
	public boolean createPerson(String firstName, String lastName, String typeDocument, String documentNumber, String user,
			String password, GregorianCalendar dateOfBirth, String typeOfPerson) throws IOException, InterruptedException, RepeatedDocumentNumberException, RepeatedUserException{
		boolean validateAge = false;
		boolean validateNumber = false;
		if(personDocuent(documentNumber) == null) {
			validateAge = true;
		}
		if(searchPersoForUser(user) == null) {
			validateNumber = true;
		}
		validateAge = validateAge == false ?!personDocuent(documentNumber).getDocumentNumber().equals(documentNumber): true;
		validateNumber = validateNumber == false ?!searchPersoForUser(user).getUser().equals(user):true;
		if (validateAge == false ) {
			throw new RepeatedDocumentNumberException();
		}else if (validateNumber == false) {
			throw new RepeatedUserException();
		}
		validateAge = managerPerson.createPerson(new Person(firstName, lastName, typeDocument.substring(0,2), documentNumber, user, password, dateOfBirth, typeOfPerson));
		return validateAge;
	}
	
	public boolean UpdatePerson(String documentNumberActual, String userActual, int id, String firstName, String lastName, String typeDocument, 
			String documentNumber, String user, String password, String year, String month, String day, String typeOfPerson) throws NumberFormatException, RepeatedDocumentNumberException, RepeatedUserException, IOException, InterruptedException, Exception {
		boolean validate = false;
		boolean validateNumber = false;
		if (documentNumberActual.equals(documentNumber) || userActual.equals(user)) {
			validate = documentNumberActual.equals(documentNumber);
			validateNumber = userActual.equals(user);
		
		}else {
			validate = searchPersoForDocuemnt(documentNumber) == null? true: false;
			validateNumber = searchPersoForUser(user) == null? true: false;
			validate = validate == false ? !searchPersoForDocuemnt(documentNumber).getDocumentNumber().equals(documentNumber): true;
			validateNumber = validateNumber == false? !searchPersoForUser(user).getUser().equals(user): true;
			}
		if (validate == false ) {
			throw new RepeatedDocumentNumberException();
		}else if (!validateNumber == false) {
			throw new RepeatedUserException();
		}
			validate = managerPerson.updatePerson(id, new Person(firstName, lastName, typeDocument, documentNumber, user, password,
					new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day)), typeOfPerson));
		return validate;
		
	}
	
	public Person searchPersoForDocuemnt(String document) throws IOException, InterruptedException, Exception {
			return managerPerson.getPersonDocument(document);
	}
	
	public Person personDocuent(String document) throws IOException, InterruptedException {
		return managerPerson.getPersonForDocument(document);
	}
	
	public Person searchPersoForUser(String user) throws IOException, InterruptedException {
			return managerPerson.getPersonUser(user);
	}
	
	public void deletPerson(String id) throws IOException, InterruptedException {
			managerPerson.deletePerson(id);
	}
	
	public Person validateUser(String user, String password) throws IOException, InterruptedException {
		return managerPerson.validate(user, password);
	}
	
	public void actualPerson(String user) throws IOException, InterruptedException {
		actualPerson = searchPersoForUser(user);
	}
	
	public Person[] showPerson() throws IOException, InterruptedException {
		return managerPerson.getShowPersons();
	}

	public Person getActualPerson() {
		return actualPerson;
	}
	
}
