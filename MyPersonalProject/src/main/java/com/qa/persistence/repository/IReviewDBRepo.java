package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Reviews;

public interface IReviewDBRepo {

	String createReview(String review);

	Reviews searchReview(Long id);

	String getAllReviews();

	String updateReview(String review, Long id);

	String deleteReview(Long id);

}