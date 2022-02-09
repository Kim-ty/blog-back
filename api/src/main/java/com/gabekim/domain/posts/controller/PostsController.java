package com.gabekim.domain.posts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
@RequestMapping(value="/posts")
public class PostsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPosts() {
      return "posts get";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String postPosts() {
      return "posts post";
    }

    @RequestMapping(method =  RequestMethod.PUT)
    public String putPosts() {
      return "posts put";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deletePosts() {
      return "posts delete";
    }


}
