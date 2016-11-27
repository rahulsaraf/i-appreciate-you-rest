package com.rest.main.service;

import java.util.List;

import com.rest.main.domain.AppreciationPost;
import com.rest.main.domain.Connections;
import com.rest.main.domain.User;

public interface UserService {

	String registerUser(String fullName, String emailAddress, String phoneNumber, String password, String sex, String city);

	String loginUser(String emailAddress, String password);

	String addConnection(Long requesterId, Long acceptorId);

	User getUser(String emailAddress);

	User getUserById(String userId);

	String saveUser(User user);

	public List<User> getAllUserConnectionsOfUser(Long userId);
	
	public AppreciationPost savePost(AppreciationPost post);
	
	public List<AppreciationPost> findAllBySenderId(User senderId);
	
	public List<AppreciationPost> findAllByReceiverId(User receiverId);
	
	public AppreciationPost findByPostId(Long postId);

	List<User> getAllUsers();

	
	
	
}
