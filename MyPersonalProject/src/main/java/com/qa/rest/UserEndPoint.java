package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IUserService;
import com.qa.persistence.domain.Users;

@Path("/users")
public class UserEndPoint {

	@Inject
	private IUserService service;

	@Path("/getAll")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}

	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public Users searchUsers(@PathParam("id") Long id) {
		return service.searchUsers(id);
	}

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String createUser(String user) {
		return service.createUser(user);
	}

	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long id, String user) {
		return service.updateUser(user, id);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long id) {
		return service.deleteUser(id);
	}

	public void setService(IUserService service) {
		this.service = service;
	}

}
