package com.example.InsuleaseServer.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@OneToMany(mappedBy="user")
	private List<Recipe> recipes;

   
	
	String username;
	String password;
	String firstName;
	String lastName;
	
	/**
	 * Default Constructor
	 */
	public User() {
		this.recipes = new ArrayList<Recipe>();
	}
	
	//Getters
	public int getUserId() {return this.userId;}
	public List<Recipe> getRecipes() {return this.recipes;}
	public String getUsername() {return this.username;}
	public String getPassword() {return this.password;}
	public String getFirstName() {return this.firstName;}
	public String getLastName() {return this.lastName;}
	
	//Setters
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	public void setUsername(String username) {this.username=username;}
	public void setPassword(String password) {this.password = password;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	
	//Edit Recipes
	public void addRecipe(Recipe recipe) {
		this.recipes.add(recipe);
		if(recipe.getUser() != this) {
			recipe.setUser(this);
		}
	}
}
