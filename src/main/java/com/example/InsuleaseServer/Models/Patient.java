package com.example.InsuleaseServer.Models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Patient extends User{
	@Temporal(TemporalType.DATE)
	private java.util.Date dob;
	
	@ManyToOne()
	@JsonIgnore
	private Provider provider;
	
	private int diagnosisAge;
	
	@OneToOne()
	private Regiment regiment;
	
	@OneToMany(mappedBy="patient")
	private List<InsulinDose> insulinDoses = new ArrayList<>();
	
	//Default constructor
	public Patient() {super();}

	//Getters
	public Date getDob() {return this.dob;}
	public int getDiagnosisAge() {return this.diagnosisAge;}
	public Provider getProvider() {return this.provider;}
	public Regiment getRegiment() {return this.regiment;}
	public List<InsulinDose> getInsulinDoses() {return this.insulinDoses;}
	
	//Setters
	public Date setDob(Date dob) {this.dob = dob; return this.dob;}
	public int setDiagnosisAge(int age) {this.diagnosisAge = age; return this.diagnosisAge;}
	public Provider setProvider(Provider provider) {
		this.provider = provider;
		return this.provider;
	}
	public Regiment setRegiment(Regiment regiment) {
		this.regiment = regiment;
		return this.regiment;
	}
	
	//update insulin doses
	public List<InsulinDose> addInsulinDose(InsulinDose dose) {
		this.insulinDoses.add(dose);
		return this.insulinDoses;
	}
	public List<InsulinDose> removeInsulinDose(InsulinDose dose){
		for (InsulinDose d : this.insulinDoses) {
			if (d.getDoseId() == dose.getDoseId()) {
				this.insulinDoses.remove(d);
			}
		}
		return this.insulinDoses;
	}
	
	
}
