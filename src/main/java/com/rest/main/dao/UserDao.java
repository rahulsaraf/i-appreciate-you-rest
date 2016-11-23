/**
 * 
 */
package com.rest.main.dao;

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
}
