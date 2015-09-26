package com.linksinnovation.microservice.web.service;

import com.linksinnovation.microservice.comment.model.Comment;
import java.util.List;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
public interface CallerService {
    public List<Comment> get();
    public Comment post(Comment comment);
}
