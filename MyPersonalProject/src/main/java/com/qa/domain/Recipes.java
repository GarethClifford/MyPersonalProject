package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recipes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String recipeID;
	private String recipeName;
	private String recipeIngredients;
	private String recipeMethod;
	@ManyToOne
	private String userID;
	
	public Recipes(String recipename, String recipeingredients, String recipemethod) {
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

	public String getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(String recipeID) {
		this.recipeID = recipeID;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userFKID) {
		this.userID = userFKID;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
