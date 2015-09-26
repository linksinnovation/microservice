package com.linksinnovation.microservice.comment.repository;

import com.linksinnovation.microservice.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    
}
