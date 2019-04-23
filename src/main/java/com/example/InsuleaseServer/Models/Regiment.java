package com.example.InsuleaseServer.Models;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Regiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int regimentId;


	
	private float a1c;
	
	private int breakfastTarget;
	private int lunchTarget;
	private int dinnerTarget;
	private int bedtimeTarget;
	private int overnightTarget;
	
	
	private int breakfastCorrection;
	private int lunchCorrection;
	private int dinnerCorrection;
	private int bedtimeCorrection;
	private int overnightCorrection;

	
	
	private float breakfastRatio;
	private float lunchRatio;
	private float dinnerRatio;
	private float bedRatio;
	private float overnightRatio;
	
	
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
		this.breakfastTarget = r.getBreakfastTarget();
		this.lunchTarget = r.getLunchTarget();
		this.dinnerTarget = r.getDinnerTarget();
		this.bedtimeTarget = r.getBedtimeTarget();
		this.overnightTarget = r.getOvernightTarget();
		
		this.breakfastCorrection = r.getBreakfastCorrection();
		this.lunchCorrection = r.getLunchCorrection();
		this.breakfastCorrection = r.getDinnerCorrection();
		this.lunchCorrection = r.getBedtimeCorrection();
		this.breakfastCorrection = r.getOvernightCorrection();
		
		this.breakfastRatio = r.getBreakfastRatio();
		this.lunchRatio = r.getLunchRatio();
		this.dinnerRatio = r.getDinnerRatio();
		this.bedRatio = r.getLunchRatio();
		
		this.basalInsulin = r.getBasalInsulin();
		this.bolusInsulin = r.getBolusInsulin();
		return this;
	}

	public int getRegimentId() {
		return regimentId;
	}

	public void setRegimentId(int regimentId) {
		this.regimentId = regimentId;
	}

	public float getA1c() {
		return a1c;
	}

	public void setA1c(float a1c) {
		this.a1c = a1c;
	}

	public int getBreakfastTarget() {
		return breakfastTarget;
	}

	public void setBreakfastTarget(int breakfastTarget) {
		this.breakfastTarget = breakfastTarget;
	}

	public int getLunchTarget() {
		return lunchTarget;
	}

	public void setLunchTarget(int lunchTarget) {
		this.lunchTarget = lunchTarget;
	}

	public int getDinnerTarget() {
		return dinnerTarget;
	}

	public void setDinnerTarget(int dinnerTarget) {
		this.dinnerTarget = dinnerTarget;
	}

	public int getBedtimeTarget() {
		return bedtimeTarget;
	}

	public void setBedtimeTarget(int bedtimeTarget) {
		this.bedtimeTarget = bedtimeTarget;
	}

	public int getOvernightTarget() {
		return overnightTarget;
	}

	public void setOvernightTarget(int overnightTarget) {
		this.overnightTarget = overnightTarget;
	}

	public int getBreakfastCorrection() {
		return breakfastCorrection;
	}

	public void setBreakfastCorrection(int breakfastCorrection) {
		this.breakfastCorrection = breakfastCorrection;
	}

	public int getLunchCorrection() {
		return lunchCorrection;
	}

	public void setLunchCorrection(int lunchCorrection) {
		this.lunchCorrection = lunchCorrection;
	}

	public int getDinnerCorrection() {
		return dinnerCorrection;
	}

	public void setDinnerCorrection(int dinnerCorrection) {
		this.dinnerCorrection = dinnerCorrection;
	}

	public int getBedtimeCorrection() {
		return bedtimeCorrection;
	}

	public void setBedtimeCorrection(int bedtimeCorrection) {
		this.bedtimeCorrection = bedtimeCorrection;
	}

	public int getOvernightCorrection() {
		return overnightCorrection;
	}

	public void setOvernightCorrection(int overnightCorrection) {
		this.overnightCorrection = overnightCorrection;
	}

	public float getBreakfastRatio() {
		return breakfastRatio;
	}

	public void setBreakfastRatio(float breakfastRatio) {
		this.breakfastRatio = breakfastRatio;
	}

	public float getLunchRatio() {
		return lunchRatio;
	}

	public void setLunchRatio(float lunchRatio) {
		this.lunchRatio = lunchRatio;
	}

	public float getDinnerRatio() {
		return dinnerRatio;
	}

	public void setDinnerRatio(float dinnerRatio) {
		this.dinnerRatio = dinnerRatio;
	}

	public float getBedRatio() {
		return bedRatio;
	}

	public void setBedRatio(float bedRatio) {
		this.bedRatio = bedRatio;
	}

	public float getOvernightRatio() {
		return overnightRatio;
	}

	public void setOvernightRatio(float overnightRatio) {
		this.overnightRatio = overnightRatio;
	}

	public String getBasalInsulin() {
		return basalInsulin;
	}

	public void setBasalInsulin(String basalInsulin) {
		this.basalInsulin = basalInsulin;
	}

	public String getBolusInsulin() {
		return bolusInsulin;
	}

	public void setBolusInsulin(String bolusInsulin) {
		this.bolusInsulin = bolusInsulin;
	}
	


}
