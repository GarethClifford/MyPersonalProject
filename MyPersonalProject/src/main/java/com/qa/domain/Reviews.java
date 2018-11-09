package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String reviewID;
	private Long reviewRating;
	private String reviewComments;
	@ManyToOne
	private String userID;
	@ManyToOne
	private String recipeID;

	
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
	


	
	
	
}
