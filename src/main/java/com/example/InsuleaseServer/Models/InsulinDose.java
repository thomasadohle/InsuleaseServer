package com.example.InsuleaseServer.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class InsulinDose {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doseId;
	
	@ManyToOne
	@JsonIgnore
	private Patient patient;
	
	private Date doseDate;
	private String doseType;
	private int carbCount;
	private int bloodGlucose;
	private float calculatedDose;
	private float actualDose;
	private String comments;
	
	//Default constructor
	private InsulinDose() {}
	
	public InsulinDose set(InsulinDose dose) {
		this.actualDose = dose.getActualDose();
		return this;
	}
	
	//getters
	public int getDoseId() {return this.doseId;}
	public Date getDoseDate() {return this.doseDate;}
	public String getDoseType() {return this.doseType;}
	public int getCarbCount() {return this.carbCount;}
	public int getBloodGlucose() {return this.bloodGlucose;}
	public float getCalculatedDose() {return this.calculatedDose;}
	public float getActualDose() {return this.actualDose;}
	public String comments() {return this.comments;}
	
	//setters
	public void setPatient(Patient patient) {this.patient=patient;}
	
}
