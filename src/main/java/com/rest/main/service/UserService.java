package com.rest.main.service;

import com.rest.main.domain.User;

public interface UserService {

	String registerUser(String fullName, String emailAddress, String phoneNumber, String password);

	String loginUser(String emailAddress, String password);

	String addConnection(Long requesterId, Long acceptorId);

	User getUser(String emailAddress);

}
