/**
 * 
 */
package com.rest.main.dao.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rest.main.domain.AppreciationPost;
import com.rest.main.domain.User;

/**
 * @author rahul
 *
 */
public interface AppreciationPostRepository extends PagingAndSortingRepository<AppreciationPost, Long>{	
	List<AppreciationPost> findAllBySenderId(User senderId);
	List<AppreciationPost> findAllByReceiverId(User receiverId);
	
	AppreciationPost findByPostId(Long postId);
}
