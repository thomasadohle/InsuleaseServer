package com.example.InsuleaseServer.Models;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Regiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int regimentId;


	
	private float a1c;
	private int dayTarget;
	private int nightTarget;
	private int dayCorrection;
	private int nightCorrection;
	private float breakfastRatio;
	private float lunchRatio;
	private float dinnerRatio;
	private float bedRatio;
	private String basalInsulin;
	private String bolusInsulin;
	
	//default constructor
	public Regiment() {}
	
	/**
	 * Method used to update a Regiment
	 * @param r is a regiment sent from the client
	 * @return this after updating
	 */
	public Regiment set(Regiment r) {
		this.a1c = r.getA1c();
		this.dayTarget = r.getDayTarget();
		this.nightTarget = r.getNightTarget();
		this.dayCorrection = r.getDayCorrection();
		this.nightCorrection = r.getNightCorrection();
		this.breakfastRatio = r.getBreakfastRatio();
		this.lunchRatio = r.getLunchRatio();
		this.dinnerRatio = r.getDinnerRatio();
		this.bedRatio = r.getLunchRatio();
		this.basalInsulin = r.getBasalInsulin();
		this.bolusInsulin = r.getBolusInsulin();
		return this;
	}
	
	//getters
	public int getRegimentId() {return this.regimentId;}
	
	public float getA1c() {return this.a1c;}
	public int getDayTarget() {return this.dayTarget;}
	public int getNightTarget() {return this.nightTarget;}
	public int getDayCorrection() {return this.dayCorrection;}
	public int getNightCorrection() {return this.nightCorrection;}
	public float getBreakfastRatio() {return this.breakfastRatio;}
	public float getLunchRatio() {return this.lunchRatio;}
	public float getDinnerRatio() {return this.dinnerRatio;}
	public float getBedRatio() {return this.bedRatio;}
	public String getBasalInsulin() {return this.basalInsulin;}
	public String getBolusInsulin() {return this.bolusInsulin;}
	
	//setters
	public void setA1c (float a1c) {this.a1c = a1c;}
	public void setDayTarget(int target) {this.dayTarget = target;}
	public void setNightTarget(int target) {this.nightTarget = target;}
	public void setDayCorrection (int cor) {this.dayCorrection = cor;}
	public void setNightCorrection(int cor) {this.nightCorrection = cor;}
	public void setBreakfastRatio(float br) {this.breakfastRatio = br;}
	public void setLunchRatio(float lr) {this.lunchRatio = lr;}
	public void setDinnerRatio (float dr) {this.dinnerRatio = dr;}
	public void setBedRatio (float br) {this.bedRatio = br;}
	public void setBasalInsulin (String b) {this.basalInsulin = b;}
	public void setBolusInsulin (String b) {this.bolusInsulin = b;}

}
