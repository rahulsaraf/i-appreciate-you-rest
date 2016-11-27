/**
 * 
 */
package com.rest.main.dao;

import java.util.List;

import com.rest.main.domain.AppreciationPost;
import com.rest.main.domain.Connections;
import com.rest.main.domain.User;

/**
 * @author rahul
 *
 */
public interface UserDao {

	public String registerUser(User user);

	public String loginUser(String emailAddress, String password);

	public User findUserByUserId(Long requesterId);

	public String addConnection(Connections conn);

	public User findUserByEmailAddress(String emailAddress);

	public String saveUser(User user);
	
	public List<Connections> getAllConnectionsOfUser(Long userId);
	
	public AppreciationPost saveAppreciationPost(AppreciationPost post);
	
	public List<AppreciationPost> findAllBySenderId(User senderId);
	
	public List<AppreciationPost> findAllByReceiverId(User receiverId);
	
	public AppreciationPost findByPostId(Long postId);

	public List<User> getAllUsers();
	
	
}
