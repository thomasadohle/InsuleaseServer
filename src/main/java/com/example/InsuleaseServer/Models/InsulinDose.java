package com.example.InsuleaseServer.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
public class InsulinDose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	// Default constructor
	public InsulinDose() {
	}

	public InsulinDose set(InsulinDose dose) {
		this.actualDose = dose.getActualDose();
		return this;
	}

	public InsulinDose(Patient patient, Date doseDate, String doseType, int carbCount, int bloodGlucose,
			float calculatedDose, float actualDose, String comments) {
		this.patient = patient;
		this.doseDate = doseDate;
		this.doseType = doseType;
		this.carbCount = carbCount;
		this.bloodGlucose = bloodGlucose;
		this.calculatedDose = calculatedDose;
		this.actualDose = actualDose;
		this.comments = comments;

	}

	public int getDoseId() {
		return doseId;
	}

	public void setDoseId(int doseId) {
		this.doseId = doseId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getDoseDate() {
		return doseDate;
	}

	public void setDoseDate(Date doseDate) {
		this.doseDate = doseDate;
	}

	public String getDoseType() {
		return doseType;
	}

	public void setDoseType(String doseType) {
		this.doseType = doseType;
	}

	public int getCarbCount() {
		return carbCount;
	}

	public void setCarbCount(int carbCount) {
		this.carbCount = carbCount;
	}

	public int getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(int bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public float getCalculatedDose() {
		return calculatedDose;
	}

	public void setCalculatedDose(float calculatedDose) {
		this.calculatedDose = calculatedDose;
	}

	public float getActualDose() {
		return actualDose;
	}

	public void setActualDose(float actualDose) {
		this.actualDose = actualDose;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
