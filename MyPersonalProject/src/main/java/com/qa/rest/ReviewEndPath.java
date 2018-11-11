package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IReviewService;
import com.qa.persistence.domain.Reviews;

@Path("/reviews")
public class ReviewEndPath {

	@Inject
	private IReviewService service;

	@Path("/getAll")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllReviews();
	}

	@Path("/getReview/{id}")
	@GET
	@Produces({ "application/json" })
	public Reviews searchReviews(@PathParam("id") Long id) {
		return service.searchReviews(id);
	}

	@Path("/createReview")
	@POST
	@Produces({ "application/json" })
	public String createReview(String review) {
		return service.createReviews(review);
	}

	@Path("/updateReview/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateReview(@PathParam("id") Long id, String review) {
		return service.updateReview(review, id);
	}

	@Path("/deleteReview/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteReview(@PathParam("id") Long id) {
		return service.deleteReview(id);
	}

	public void setService(IReviewService service) {
		this.service = service;
	}

}
