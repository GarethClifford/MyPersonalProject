package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Recipes;
import com.qa.persistence.repository.RecipeDBRepo;

public class RecipeService implements IRecipeService {

	@Inject
	RecipeDBRepo repo;

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRecipeService#createRecipe(java.lang.String)
	 */
	@Override
	public String createRecipe(String recipe) {
		return repo.createRecipe(recipe);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRecipeService#searchRecipe(java.lang.Long)
	 */
	@Override
	public Recipes searchRecipe(Long id) {
		return repo.searchRecipe(id);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRecipeService#getAllRecipes()
	 */
	@Override
	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRecipeService#updateRecipe(java.lang.String, java.lang.Long)
	 */
	@Override
	public String updateRecipe(String recipe, Long id) {
		return repo.updateRecipe(recipe, id);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRecipeService#deleteRecipe(java.lang.Long)
	 */
	@Override
	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

}
