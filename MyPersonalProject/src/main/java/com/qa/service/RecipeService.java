package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import com.qa.domain.Recipe;

public class RecipeService {
	
	private Map<Integer, Recipe> recipeMap;
	private int count = 0;
	
	public RecipeService() {
		recipeMap = new HashMap<Integer, Recipe>();
	}
	
	public void addRecipeFromMap(Recipe newRecipe) {
		recipeMap.put(count, newRecipe);
		count++;
	}
	
	public void removeRecipedFromMap(Integer recipeToRemove) {
		boolean countExists = recipeMap.containsKey(recipeToRemove);
		if (countExists) {
			recipeMap.remove(recipeToRemove);
		}
	}
	
	public Map<Integer, Recipe> getRecipeMap() {
		return recipeMap;
	}
	
	

}
