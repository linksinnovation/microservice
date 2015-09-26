package com.linksinnovation.microservice.comment.controller;

import com.linksinnovation.microservice.comment.model.Comment;
import com.linksinnovation.microservice.comment.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jirawong Wongdokpuang <greannetwork@gmail.com>
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> get() {
        return commentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment post(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

}
