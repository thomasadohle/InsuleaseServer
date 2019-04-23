package com.example.InsuleaseServer.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Patient extends User {
	@Temporal(TemporalType.DATE)
	private java.util.Date dob;

	private int diagnosisAge;

	@OneToOne()
	private Regiment regiment;

	@OneToMany(mappedBy = "patient")
	private List<InsulinDose> insulinDoses;

	@ManyToMany(mappedBy = "patientList")
	@JsonIgnore
	private List<Provider> providerList;

	// Default constructor
	public Patient() {
		super();
		this.insulinDoses = new ArrayList<>();
		this.providerList = new ArrayList<>();
	}

	// Getters
	public Date getDob() {
		return this.dob;
	}

	public int getDiagnosisAge() {
		return this.diagnosisAge;
	}

	public Regiment getRegiment() {
		return this.regiment;
	}

	public List<InsulinDose> getInsulinDoses() {
		return this.insulinDoses;
	}

	public void setInsulinDoses(List<InsulinDose> insulinDoses) {
		this.insulinDoses = insulinDoses;
	}

	public List<Provider> getProviders() {
		return this.providerList;
	}

	// Setters
	public Date setDob(Date dob) {
		this.dob = dob;
		return this.dob;
	}

	public int setDiagnosisAge(int age) {
		this.diagnosisAge = age;
		return this.diagnosisAge;
	}

	public Regiment setRegiment(Regiment regiment) {
		this.regiment = regiment;
		return this.regiment;
	}
	
	public List<Provider> getProviderList() {
		return providerList;
	}

	public void setProviderList(List<Provider> providerList) {
		this.providerList = providerList;
	}

	// update insulin doses
	public void addInsulinDose(InsulinDose dose) {
		this.insulinDoses.add(dose);
		if(dose.getPatient() != this){
			dose.setPatient(this);
		}
	}

	// Edit Providers
	public void addProvider(Provider provider) {
		this.providerList.add(provider);
		if(!provider.getPatientList().contains(this)) {
			provider.getPatientList().add(this);
		}
	}
}
