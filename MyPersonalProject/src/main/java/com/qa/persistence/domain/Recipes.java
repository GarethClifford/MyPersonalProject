package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private String recipeID;
	@Column(length = 50)
	private String recipeName;
	@Column(length = 250)
	private String recipeIngredients;
	@Column(length = 300)
	private String recipeMethod;
	
	@JoinColumn(name = "userID")
	private String userID;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "reviewID")
	private Set<Reviews> reviews;

	public Recipes() {
	}

	public Recipes(String recipename, String recipeingredients, String recipemethod, String userid) {
		this.recipeName = recipename;
		this.recipeIngredients = recipeingredients;
		this.recipeMethod = recipemethod;
		this.userID = userid;
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

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

}
