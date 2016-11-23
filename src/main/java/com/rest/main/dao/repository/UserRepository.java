package com.rest.main.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rest.main.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, String>{	
	User findByEmailAddress(String emailAddress);
	
	User findByUserId(Long userId);
}
