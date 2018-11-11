package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Users;
import com.qa.persistence.repository.UserDBRepo;

public class UserService implements IUserService {

	@Inject
	UserDBRepo repo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.business.service.IUserService#createUser(java.lang.String)
	 */
	@Override
	public String createUser(String user) {
		return repo.createUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.business.service.IUserService#searchUsers(java.lang.Long)
	 */
	@Override
	public Users searchUsers(Long id) {
		return repo.searchUsers(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.business.service.IUserService#getAllUsers()
	 */
	@Override
	public String getAllUsers() {
		return repo.getAllUsers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.business.service.IUserService#updateUser(java.lang.String,
	 * java.lang.Long)
	 */
	@Override
	public String updateUser(String user, Long id) {
		return repo.updateUser(user, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qa.business.service.IUserService#deleteUser(java.lang.Long)
	 */
	@Override
	public String deleteUser(Long id) {
		return repo.deleteUser(id);
	}

}