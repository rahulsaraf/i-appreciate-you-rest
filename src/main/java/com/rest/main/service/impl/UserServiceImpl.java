/**
 * 
 */
package com.rest.main.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.main.dao.UserDao;
import com.rest.main.domain.Connections;
import com.rest.main.domain.User;
import com.rest.main.service.UserService;

/**
 * @author rahul
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	public String registerUser(String fullName, String emailAddress, String phoneNumber, String password) {
		User user = new User();
		user.setFullName(fullName);
		user.setEmailAddress(emailAddress.toLowerCase());
		user.setPhone(phoneNumber);
		user.setPassword(password);
		
		return userDao.registerUser(user);
	}
	
	public String loginUser(String emailAddress, String password){
		return userDao.loginUser(emailAddress, password);
	}

	@Override
	public String addConnection(Long requesterId, Long acceptorId) {
		User requester = userDao.findUserByUserId(requesterId);
		User acceptor = userDao.findUserByUserId(acceptorId);
		Connections conn = new Connections();
		conn.setRequesterId(requester);
		conn.setAccepterId(acceptor);
		conn.setActive(true);
		conn.setConnCreationTime(new Date());
		
		return userDao.addConnection(conn);
	}

	@Override
	public User getUser(String emailAddress) {
		
		return userDao.findUserByEmailAddress(emailAddress);
	}
	
	

}
