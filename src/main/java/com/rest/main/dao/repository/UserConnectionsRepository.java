package com.rest.main.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rest.main.domain.Connections;
import com.rest.main.domain.User;

public interface UserConnectionsRepository extends PagingAndSortingRepository<Connections, Long>{	
	Connections findByConnId(Long connId);
	
	
	@Query("select a from Connections a join a.requesterId u1 join a.accepterId u2 where u1.userId=:userId or u2.userId=:userId")
	List<Connections> findAllConnetionsByUserId(@Param("userId")Long userId);
}
