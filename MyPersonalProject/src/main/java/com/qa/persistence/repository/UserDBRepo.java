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
import com.qa.persistence.domain.Users;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepo implements IUserDBRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IUser#createUser(java.lang.String)
	 */
	@Override
	@Transactional(REQUIRED)
	public String createUser(String user) {
		Users u = util.getObjectforJSON(user, Users.class);
		em.persist(u);

		return "{\"message\": \"User sucessfully created\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IUser#searchUsers(java.lang.Long)
	 */
	@Override
	public Users searchUsers(Long id) {
		return em.find(Users.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IUser#getAllUsers()
	 */
	@Override
	public String getAllUsers() {
		Query query = em.createQuery("SELECT u FROM Users u");
		Collection<Users> users = (Collection<Users>) query.getResultList();
		return util.getJSONForObject(users);
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IUser#updateUser(java.lang.String, java.lang.Long)
	 */
	@Transactional(REQUIRED)
	@Override
	public String updateUser(String user, Long id) {
		Users newInfo = util.getObjectforJSON(user, Users.class);
		Users oldInfo = em.find(Users.class, id);

		oldInfo.setUserName(newInfo.getUserName());

		return "{\"message\": \"User sucessfully updated\"}";
	}

	/* (non-Javadoc)
	 * @see com.qa.persistence.repository.IUser#deleteUser(java.lang.Long)
	 */
	@Transactional(REQUIRED)
	@Override
	public String deleteUser(Long id) {
		if (em.find(Users.class, id) != null) {
			em.remove(em.find(Users.class, id));
			return "{\"message\": \"User sucessfully deleted\"}";
		} else
			return "{\"message\": \"User not found\"}";
	}

}
