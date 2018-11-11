package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Reviews;
import com.qa.persistence.repository.ReviewDBRepo;

public class ReviewService implements IReviewService {

	@Inject
	ReviewDBRepo repo;

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRevewService#createReviews(java.lang.String)
	 */
	@Override
	public String createReviews(String review) {
		return repo.createReview(review);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRevewService#searchReviews(java.lang.Long)
	 */
	@Override
	public Reviews searchReviews(Long id) {
		return repo.searchReview(id);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRevewService#getAllReviews()
	 */
	@Override
	public String getAllReviews() {
		return repo.getAllReviews();
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRevewService#updateReview(java.lang.String, java.lang.Long)
	 */
	@Override
	public String updateReview(String review, Long id) {
		return repo.updateReview(review, id);
	}

	/* (non-Javadoc)
	 * @see com.qa.business.service.IRevewService#deleteReview(java.lang.Long)
	 */
	@Override
	public String deleteReview(Long id) {
		return repo.deleteReview(id);
	}

}