package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import com.qa.domain.Recipes;

public class RecipeService {
	
	private Map<Integer, Recipes> recipeMap;
	private int count = 0;
	
	public RecipeService() {
		recipeMap = new HashMap<Integer, Recipes>();
	}
	
	public void addRecipeFromMap(Recipes newRecipe) {
		recipeMap.put(count, newRecipe);
		count++;
	}
	
	public void removeRecipedFromMap(Integer recipeToRemove) {
		boolean countExists = recipeMap.containsKey(recipeToRemove);
		if (countExists) {
			recipeMap.remove(recipeToRemove);
		}
	}
	
	public Map<Integer, Recipes> getRecipeMap() {
		return recipeMap;
	}
	
	

}
