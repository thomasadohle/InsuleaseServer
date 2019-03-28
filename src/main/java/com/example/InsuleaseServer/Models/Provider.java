package com.example.InsuleaseServer.Models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Provider extends User{

	
	@OneToMany(mappedBy="provider")
	List<Patient> patients = new ArrayList<>();
	
	private String credentials;
	private String phone;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	//Default constructor
	public Provider() {
		super();
	}
	
	//getters
	public String getCredentials() {return this.credentials;}
	public String getPhone() {return this.phone;}
	public String getStreet() {return this.street;}
	public String getCity() {return this.city;}
	public String getState() {return this.state;}
	public int getZip() {return this.zip;}
	public List<Patient> getPatients() {return this.patients;}
	
	//Setters
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public void setPhone(String phone) {this.phone=phone;}
	public void setStreet(String street) {this.street=street;}
	public void setCity(String city) {this.city=city;}
	public void setState(String state) {this.state = state;}
	public void setZip(int zip) {this.zip=zip;}
	
	//Add/remove patients
	public List<Patient> addPatient(Patient patient) {
		this.patients.add(patient);
		return this.patients;
	}
	public List<Patient> removePatient(Patient patient) {
		for (Patient p : this.patients) {
			if (p.getUserId() == patient.getUserId()) {
				this.patients.remove(p);
			}
		}
		return this.patients;
	}
}