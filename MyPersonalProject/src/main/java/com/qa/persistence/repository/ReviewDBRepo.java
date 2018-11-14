package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Reviews;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ReviewDBRepo implements IReviewDBRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IReview#createReview(java.lang.String)
	 */
	@Override
	@Transactional(REQUIRED)
	public String createReview(String review) {
		Reviews r = util.getObjectforJSON(review, Reviews.class);
		em.persist(r);
		return "{\"message\": \"Review successfully created\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IReview#searchReview(java.lang.Long)
	 */
	@Override
	public Reviews searchReview(Long id) {
		return em.find(Reviews.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IReview#getAllReviews()
	 */
	@Override
	public String getAllReviews() {
		Query query = em.createQuery("SELECT r FROM Reviews r");
		Collection<Reviews> reviews = (Collection<Reviews>) query.getResultList();
		return util.getJSONForObject(reviews);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IReview#updateReview(java.lang.String, java.lang.Long)
	 */
	@Override
	@Transactional(REQUIRED)
	public String updateReview(String review, Long id) {
		Reviews newInfo = util.getObjectforJSON(review, Reviews.class);
		Reviews oldInfo = em.find(Reviews.class, id);

		oldInfo.setReviewRating(newInfo.getReviewRating());
		oldInfo.setReviewComments(newInfo.getReviewComments());

		return "{\"message\": \"Review successfully updated\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IReview#deleteReview(java.lang.Long)
	 */
	@Override
	@Transactional(REQUIRED)
	public String deleteReview(Long id) {
		if (em.find(Reviews.class, id) != null) {
			em.remove(em.find(Reviews.class, id));
			return "{\"message\": \"Review successfully deleted\"}";
		} else
			return "{\"message\": \"Review not found\"}";
	}

}
