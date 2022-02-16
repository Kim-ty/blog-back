package com.gabekim.domain.posts.controller;

import com.gabekim.domain.posts.dto.PostsDto;
import com.gabekim.domain.posts.service.PostsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
@RequestMapping(value="/Posts")
public class PostsController {

    @Autowired
    PostsService postsService;


    @RequestMapping(method = RequestMethod.GET)
    public Slice<PostsDto> getPosts(PostsDto param) {
      Slice<PostsDto> postsList = postsService.getPosts(param);

      return postsList;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postPosts(PostsDto param) {
      int result = 0;

      try {
        result = postsService.postPosts(param);

      }catch (Error error){
        return new ResponseEntity<>(error,HttpStatus.UNPROCESSABLE_ENTITY);
      }

      return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @RequestMapping(method =  RequestMethod.PUT)
    public String putPosts(PostsDto param) {
      return "posts put";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deletePosts(int param) {
      return "posts delete";
    }


}
