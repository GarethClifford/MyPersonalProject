package com.qa.business.service;

import com.qa.persistence.domain.Recipes;

public interface IRecipeService {

	String createRecipe(String recipe);

	Recipes searchRecipe(Long id);

	String getAllRecipes();

	String updateRecipe(String recipe, Long id);

	String deleteRecipe(Long id);

}