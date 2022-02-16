package com.gabekim.domain.posts.mapper;

import java.util.ArrayList;
import java.util.List;

import com.gabekim.domain.posts.dto.PostsDto;
import com.gabekim.entity.Posts;

public class PostsMapper {
    //dtoConverter 함수
    public List<PostsDto> entityListToDtoList(List<Posts> posts) {
      List<PostsDto> list = new ArrayList<PostsDto>();
  
  
      for(Posts item: posts){
        PostsDto dto = new PostsDto(item);
        list.add(dto);
      }
  
      return list;
    } 
}
