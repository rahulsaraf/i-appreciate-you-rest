package com.rest.main.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rest.main.domain.Connections;

public interface UserConnectionsRepository extends PagingAndSortingRepository<Connections, Long>{	
	Connections findByConnId(Long connId);
}
