package com.gabekim.domain.posts.service;

import com.gabekim.domain.posts.dto.PostsDto;

import org.springframework.data.domain.Slice;

public interface PostsService {
    
  public Slice<PostsDto> getPosts(PostsDto postsDto);

  public Integer postPosts(PostsDto postsDto);

  public String putPosts(PostsDto postsDto);

  public Integer deletePosts(int postsNo);


}
