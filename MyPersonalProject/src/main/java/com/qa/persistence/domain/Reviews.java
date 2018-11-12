package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 4)
	private String reviewID;
	@Column(length = 1)
	private Long reviewRating;
	@Column(length = 100)
	private String reviewComments;
	
	@JoinColumn(name = "userID")
	private String userID;

	@JoinColumn(name = "recipeID")
	private String recipeID;

	public Reviews() {
	}

	public Reviews(Long reviewrating, String reviewcomments) {
		this.reviewRating = reviewrating;
		this.reviewComments = reviewcomments;
	}

	public String getReviewID() {
		return reviewID;
	}

	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}

	public Long getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(Long reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getReviewComments() {
		return reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
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

}
