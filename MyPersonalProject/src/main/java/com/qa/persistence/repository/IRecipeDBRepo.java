package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Recipes;

public interface IRecipeDBRepo {

	String createRecipe(String recipe);

	Recipes searchRecipe(Long id);

	String getAllRecipes();

	String updateRecipe(String recipe, Long id);

	String deleteRecipe(Long id);

}