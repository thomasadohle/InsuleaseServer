package com.example.InsuleaseServer.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuleaseServer.Models.Recipe;
import com.example.InsuleaseServer.Models.User;
import com.example.InsuleaseServer.Repositories.RecipeRepository;
import com.example.InsuleaseServer.Repositories.UserRepository;


@CrossOrigin(origins = {"*"}, allowCredentials = "true", allowedHeaders = "*")
@RestController
public class RecipeService {
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@GetMapping("api/user/{userId}/recipe")
	public List<Recipe> findAllRecipes(@PathVariable(value="userId") int userId){
		System.out.println("userId sent is: " + userId);
		List<Recipe> recipes = recipeRepository.findRecipesByUser(userId);
		return recipes;
	}
	
	@GetMapping("api/user/{userId}/recipe/{limit}")
	public List<Recipe> findAllRecipesLimit(@PathVariable(value="userId") int userId,
			@PathVariable(value="limit") int limit){
		List<Recipe> recipes = recipeRepository.findRecipesByUserLimited(userId,limit);
		return recipes;
	}
	
	@PostMapping("api/user/{userId}/recipe")
	public Recipe addRecipe(@PathVariable(value="userId") int userId, @RequestBody Recipe recipe) {
		User user = userRepository.findById(userId).get();
		recipe.setUser(user);
		user.addRecipe(recipe);
		userRepository.save(user);
		recipeRepository.save(recipe);
		return recipe;
	}
	
	@DeleteMapping("api/recipe/{recipeId}")
	public void deleteRecipe(@PathVariable(value="recipeId") int recipeId) {
		recipeRepository.deleteById(recipeId);
	}

}
