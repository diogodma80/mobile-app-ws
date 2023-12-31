package com.dma.app.ws.ui.model.request;

// json being passed from the UI to the controller

/*
 * 	{
 * 		"firstName":"FirstName",
 * 		"lastName": "LastName",
 * 		"email":"FirstName.LastName@email.com",
 * 		"password":"password123"
 * 	}
 * */
public class UserDetailsRequestModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
