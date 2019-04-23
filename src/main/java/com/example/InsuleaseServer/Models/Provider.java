package com.example.InsuleaseServer.Models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Provider extends User{

	
	@ManyToMany
	@JoinTable(name="relationship",
	joinColumns= @JoinColumn(name="provider_id", referencedColumnName="userId"),
	inverseJoinColumns=@JoinColumn(name="patient_id", referencedColumnName="userId"))
	@JsonIgnore
	private List<Patient> patientList;
	
	private String credentials;
	private String phone;
	private String street;
	private String city;
	private String state;
	private int zip;
	
	//Default constructor
	public Provider() {
		super();
		this.patientList = new ArrayList<>();
	}

	//getters
	public List<Patient> getPatientList() {
		return patientList;
	}
	public String getCredentials() {return this.credentials;}
	public String getPhone() {return this.phone;}
	public String getStreet() {return this.street;}
	public String getCity() {return this.city;}
	public String getState() {return this.state;}
	public int getZip() {return this.zip;}
	
	//Setters
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public void setPhone(String phone) {this.phone=phone;}
	public void setStreet(String street) {this.street=street;}
	public void setCity(String city) {this.city=city;}
	public void setState(String state) {this.state = state;}
	public void setZip(int zip) {this.zip=zip;}
	
	//Add/remove patients
	public void addPatient(Patient patient) {
		this.patientList.add(patient);
		if(!patient.getProviderList().contains(this)) {
			patient.getProviderList().add(this);
		}
	}
}
