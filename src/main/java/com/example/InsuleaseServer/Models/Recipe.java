package com.example.InsuleaseServer.Models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recipeId;
	
	@ManyToOne()
	@JsonIgnore
	User user;
	
	String label; //This is the recipe name from the edmam API
	String image; //Image URL from edmam API
	String shareAs; // URL of recipe from API
	int calories;
	int carbs;
	int protein;
	
	//Default constructor
	public Recipe() {}
	
	//getters
	public int getRecipeId() {return this.recipeId;}
	public String getLabel() {return this.label;}
	public String getImage() {return this.image;}
	public String getShareAs() {return this.shareAs;}
	public int getCalories() {return this.calories;}
	public int getCarbs() {return this.carbs;}
	public int getProtein() {return this.protein;}
	
	//setters
	public void setUser(User user) {this.user=user;}
}
