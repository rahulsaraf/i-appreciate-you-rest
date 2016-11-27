/**
 * 
 */
package com.rest.main.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.main.dao.UserDao;
import com.rest.main.domain.AppreciationPost;
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

	public String registerUser(String fullName, String emailAddress, String phoneNumber, String password,String sex,String city) {
		User user = new User();
		user.setFullName(fullName);
		user.setEmailAddress(emailAddress.toLowerCase());
		user.setPhone(phoneNumber);
		user.setPassword(password);
		user.setSex(sex);
		String[] loc = city.split(",");
		if(loc.length == 3){
			user.setCity(loc[0]);
			user.setState(loc[1]);
			user.setCountry(loc[2]);			
		}
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
		if(userDao.addConnection(conn).equals("success")){
			requester.setNoOfConnections(requester.getNoOfConnections() + 1);
			acceptor.setNoOfConnections(acceptor.getNoOfConnections()+1);
			userDao.saveUser(acceptor);
			userDao.saveUser(requester);
		}
		return userDao.addConnection(conn);
	}

	@Override
	public User getUser(String emailAddress) {
		
		return userDao.findUserByEmailAddress(emailAddress);
	}

	@Override
	public User getUserById(String userId) {
		return userDao.findUserByUserId(Long.valueOf(userId));
	}

	@Override
	public String saveUser(User user) {
		
		return userDao.saveUser(user);
	}

	@Override
	public List<User> getAllUserConnectionsOfUser(Long userId) {
		List<Connections> conns = userDao.getAllConnectionsOfUser(userId);	
		List<User> users = new ArrayList<User>();
		for (Connections connection : conns) {
			if(connection.getAccepterId().getUserId() == userId){
				users.add(connection.getRequesterId());
			}else{
				users.add(connection.getAccepterId());
			}
		}
		return users;
	}

	@Override
	public List<AppreciationPost> findAllBySenderId(User senderId) {
		return userDao.findAllBySenderId(senderId);
	}

	@Override
	public List<AppreciationPost> findAllByReceiverId(User receiverId) {
		return userDao.findAllByReceiverId(receiverId);
	}

	@Override
	public AppreciationPost findByPostId(Long postId) {
		return userDao.findByPostId(postId);
	}

	@Override
	public AppreciationPost savePost(AppreciationPost post) {
		return userDao.saveAppreciationPost(post);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}
}
