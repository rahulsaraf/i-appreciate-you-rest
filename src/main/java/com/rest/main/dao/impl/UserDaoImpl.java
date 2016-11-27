/**
 * 
 */
package com.rest.main.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.main.dao.UserDao;
import com.rest.main.dao.repository.AppreciationPostRepository;
import com.rest.main.dao.repository.UserConnectionsRepository;
import com.rest.main.dao.repository.UserLoginInfoRepository;
import com.rest.main.dao.repository.UserRepository;
import com.rest.main.domain.AppreciationPost;
import com.rest.main.domain.Connections;
import com.rest.main.domain.User;
import com.rest.main.domain.UserLoginInfo;

/**
 * @author rahul
 *
 */

@Service
public class UserDaoImpl implements UserDao{


	private UserRepository userRepo;
	private UserLoginInfoRepository infoRepo;
	private UserConnectionsRepository connRepo;
	private AppreciationPostRepository postRepo;

    @Autowired
    public UserDaoImpl(UserRepository userRepo, UserLoginInfoRepository infoRepo,UserConnectionsRepository connRepo,AppreciationPostRepository postRepo) {
        this.userRepo = userRepo;
        this.infoRepo = infoRepo;
        this.connRepo = connRepo;
        this.postRepo = postRepo;
    }
	
	public String registerUser(User user){
		User userExists = userRepo.findByEmailAddress(user.getEmailAddress());
		if(userExists == null){
			userRepo.save(user);
			return "success";
		}else{
			return "Email Address is already in system";
		}
	}
	
	public String loginUser(String emailAddress, String password){
		User userExists = userRepo.findByEmailAddress(emailAddress.toLowerCase());
		if(userExists == null){
			return "User with email address "+emailAddress + " does not exists.!";
		}else if(!password.equals(userExists.getPassword())){
			return "Incorrect Password.!";
		}else{
			UserLoginInfo loginInfo = new UserLoginInfo();
			loginInfo.setUserId(userExists);
			loginInfo.setLastLoginTime(new Date());
			infoRepo.save(loginInfo);
			return "success";
		}
	}

	@Override
	public User findUserByUserId(Long requesterId) {
		return userRepo.findByUserId(requesterId);
	}

	@Override
	public String addConnection(Connections conn) {
		Connections saved = connRepo.save(conn);
		if(saved == null){
			return "Connection request failed, Please try again.";
		}else{
			return "success";			
		}
	}

	@Override
	public User findUserByEmailAddress(String emailAddress) {
		return userRepo.findByEmailAddress(emailAddress.toLowerCase());
	}

	@Override
	public String saveUser(User user) {
		User saved = userRepo.save(user);
		
		if(saved == null){
			return "User update request failed, Please try again.";
		}else{
			return "success";			
		}
	}

	@Override
	public List<Connections> getAllConnectionsOfUser(Long userId) {
		List<Connections> connections = connRepo.findAllConnetionsByUserId(userId);
		return connections;
	}

	@Override
	public AppreciationPost saveAppreciationPost(AppreciationPost post) {
		postRepo.save(post);
		return post;
	}

	@Override
	public List<AppreciationPost> findAllBySenderId(User senderId) {
		return postRepo.findAllBySenderId(senderId);
	}

	@Override
	public List<AppreciationPost> findAllByReceiverId(User receiverId) {
		return postRepo.findAllByReceiverId(receiverId);
	}

	@Override
	public AppreciationPost findByPostId(Long postId) {
		return postRepo.findByPostId(postId);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	
	
	
	
	
	
	
}
