package com.linksinnovation.microservice.web.service;

import com.linksinnovation.microservice.comment.model.Comment;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@Service
public class CommentCallerService implements CallerService{
    
    private static final String service = "http://COMMENT-SERVICE/comment/";
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Comment> get() {
        Comment[] get = restTemplate.getForObject(service, Comment[].class);
        return Arrays.asList(get);
    }

    @Override
    public Comment post(Comment comment) {
        return restTemplate.postForObject(service, comment, Comment.class);
    }
    
}
