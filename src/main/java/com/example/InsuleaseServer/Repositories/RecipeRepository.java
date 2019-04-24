package com.example.InsuleaseServer.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.InsuleaseServer.Models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
	@Query(value="SELECT * FROM recipe WHERE user_user_id=:userId",
			nativeQuery=true)
	public List<Recipe> findRecipesByUser(@Param("userId") int userId);
	
	@Query(value="SELECT * FROM recipe WHERE user_user_id=:userId ORDER BY recipe_id DESC LIMIT :limit",
			nativeQuery=true)
	public List<Recipe> findRecipesByUserLimited(@Param("userId")int userId, @Param("limit") int limit);
	
	@Query(value="SELECT * FROM recipe ORDER BY recipe_id DESC LIMIT :limit",
			nativeQuery=true)
	public List<Recipe> findRecipesLimited(@Param("limit") int limit);

}
