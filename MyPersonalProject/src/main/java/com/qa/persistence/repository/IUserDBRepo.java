package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Users;

public interface IUserDBRepo {

	String createUser(String user);

	Users searchUsers(Long id);

	String getAllUsers();

	String updateUser(String user, Long id);

	String deleteUser(Long id);

}