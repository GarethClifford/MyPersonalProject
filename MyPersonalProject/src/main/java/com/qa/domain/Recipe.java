package com.qa.domain;

public class Recipe {
	
	private String recipeName;
	private String recipeIngredients;
	private String recipeMethod;
	
	public Recipe(String recipename, String recipeingredients, String recipemethod) {
		this.recipeName = recipename;
		this.recipeIngredients = recipeingredients;
		this.recipeMethod = recipemethod;
	}
	

	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeIngredients() {
		return recipeIngredients;
	}
	public void setRecipeIngredients(String recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	public String getRecipeMethod() {
		return recipeMethod;
	}
	public void setRecipeMethod(String recipeMethod) {
		this.recipeMethod = recipeMethod;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
