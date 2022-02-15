package com.gabekim.domain.posts.service;

import java.util.ArrayList;

import com.gabekim.domain.posts.dto.PostsDto;

public interface PostsService {
    
  public ArrayList<PostsDto> getPosts();

  public Integer postPosts();

  public String putPosts();

  public Integer deletePosts();


}
