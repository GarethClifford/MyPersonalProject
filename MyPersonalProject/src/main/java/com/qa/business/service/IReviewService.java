package com.qa.business.service;

import com.qa.persistence.domain.Reviews;

public interface IReviewService {

	String createReviews(String review);

	Reviews searchReviews(Long id);

	String getAllReviews();

	String updateReview(String review, Long id);

	String deleteReview(Long id);

}