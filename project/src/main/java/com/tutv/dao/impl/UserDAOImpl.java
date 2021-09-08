/**
 * @package com.tutv.dao.impl
 * @date Sep 7, 2021
 * @author trinh
 */
package com.tutv.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.tutv.dao.UserDAO;
import com.tutv.response.UserResponse;

/**
 * UserDAOImpl
 */
@Transactional
public class UserDAOImpl implements UserDAO{

	/**
	 * Property sessionFactory
	 */
	private SessionFactory sessionFactory;
	
	/**
	 * setSessionFactory
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * getUser
	 *
	 * @param id
	 * @return user
	 */
	@Override
	public UserResponse getUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserResponse> query = builder.createQuery(UserResponse.class);
		Root<UserResponse> root = query.from(UserResponse.class);
		Predicate p = builder.equal(root.get("id"), id);
		query.select(root).where(p);
		UserResponse user = session.createQuery(query).uniqueResult();
		return user;
	}

}
