package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IRecipeService;
import com.qa.persistence.domain.Recipes;

@Path("/recipes")
public class RecipeEndPoint {

	@Inject
	private IRecipeService service;

	@Path("/getAll")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return service.getAllRecipes();
	}

	@Path("/getRecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public Recipes searchRecipes(@PathParam("id") Long id) {
		return service.searchRecipe(id);
	}

	@Path("/createRecipe")
	@POST
	@Produces({ "application/json" })
	public String createRecipe(String recipe) {
		return service.createRecipe(recipe);
	}

	@Path("/updateRecipe/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateRecipe(@PathParam("id") Long id, String recipe) {
		return service.updateRecipe(recipe, id);
	}

	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRecipe(@PathParam("id") Long id) {
		return service.deleteRecipe(id);
	}

	public void setService(IRecipeService service) {
		this.service = service;
	}

}
