package com.qa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userID;
	private String userName;
	@OneToMany
	private String recipeID;
	@OneToMany
	private String reviewID;
	
	public Users(String userid, String username) {
		this.userID = userid;
		this.userName = username;
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

	public String getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(String recipeID) {
		this.recipeID = recipeID;
	}

	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	
	
	
	
	
	
	

}
