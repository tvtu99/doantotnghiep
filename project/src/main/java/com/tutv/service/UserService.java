/**
 * @package com.tutv.service
 * @date Sep 7, 2021
 * @author trinh
 */
package com.tutv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tutv.dao.UserDAO;
import com.tutv.response.UserResponse;

/**
 * UserService
 */
@Service
public class UserService implements UserDetailsService{

	/**
	 * Field userDAO
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * getUser
	 *
	 * @param id
	 * @return user
	 */
	public UserResponse getUser(Integer id) {
		UserResponse user = userDAO.getUser(id);
		return user;
	}

	/**
	 * loadUserByUsername
	 *
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
