package com.qa.business.service;

import com.qa.persistence.domain.Users;

public interface IUserService {

	String createUser(String user);

	Users searchUsers(Long id);

	String getAllUsers();

	String updateUser(String user, Long id);

	String deleteUser(Long id);

}