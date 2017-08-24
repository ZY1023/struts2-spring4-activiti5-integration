package com.informatics.dev.action;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.informatics.dev.model.Person;
import com.informatics.dev.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class CreateTaskAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Person person;
	
	PersonService personService;
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String execute() throws Exception {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Person>> violations = validator.validate(person);

		if (violations.size() > 0) {
			for (ConstraintViolation<Person> model : violations) {
				addActionError(model.getMessage());
				System.out.println(model.getMessage());
			}
			return "error";
		}
		personService.startTask(person);
		System.out.println("Adding Person .. " + person.getUserName());
		return "SUCCESS";
	}
}