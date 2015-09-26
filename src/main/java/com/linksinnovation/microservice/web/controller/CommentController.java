package com.linksinnovation.microservice.web.controller;

import com.linksinnovation.microservice.comment.model.Comment;
import com.linksinnovation.microservice.web.service.CallerService;
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
    private CallerService callerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> get() {
        return callerService.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comment post(@RequestBody Comment comment) {
        return callerService.post(comment);
    }

}
