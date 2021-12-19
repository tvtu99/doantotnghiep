/**
 * @package com.tutv.dao
 * @date Dec 11, 2021
 * @author trinh
 */
package com.tutv.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.tutv.dao.HoSoXetTuyenDAO;

/**
 * HoSoXetTuyenDAO
 */
@Transactional
public class HoSoXetTuyenDAOImpl implements HoSoXetTuyenDAO{
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
}
