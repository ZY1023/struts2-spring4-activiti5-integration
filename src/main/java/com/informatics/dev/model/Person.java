package com.informatics.dev.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Person{
	@NotNull(message = "user name cannot be empty")
	@NotBlank(message = "user name cannot be empty")
	private String userName;
	
	@Min(value = 15, message = "Age should be greater than 15")
	private int age;
	
	@Email
	@NotBlank(message = "Email cannot be empty")
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String toString()
    {
        return "Username: " + getUserName()+ " Age:  " + getAge() + 
        " Email:      " + getEmail();
    }
}
