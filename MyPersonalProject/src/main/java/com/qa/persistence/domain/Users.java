package com.qa.persistence.domain;

import java.util.List;
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
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private String userID;
	@Column(length = 50)
	private String userName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Recipes> recipes;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id")
	private Set<Reviews> review;

	public Users() {
	}

	public Users(String userid, String username, Set<Recipes> recipes) {
		this.userID = userid;
		this.userName = username;
		this.recipes = recipes;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public List<Recipes> getRecipe() {
		return getRecipe();
	}

	public void setRecipeID(Set<Recipes> recipe) {
		this.recipes = recipe;
	}

	public Set<Reviews> getReview() {
		return review;
	}

	public void setReview(Set<Reviews> reviews) {
		this.review = reviews;
	}

}
