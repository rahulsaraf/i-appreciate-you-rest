package com.rest.main.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rest.main.domain.User;
import com.rest.main.domain.UserLoginInfo;

public interface UserLoginInfoRepository extends PagingAndSortingRepository<UserLoginInfo, Long>{	
	UserLoginInfo findByUserId(String userId);
}
