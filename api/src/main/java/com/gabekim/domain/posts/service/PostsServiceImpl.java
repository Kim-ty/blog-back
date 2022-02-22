package com.gabekim.domain.posts.service;

import java.util.ArrayList;
import java.util.List;

import com.gabekim.domain.posts.dto.PostsDto;
import com.gabekim.domain.posts.mapper.PostsMapper;
import com.gabekim.domain.posts.repository.PostsRepository;
import com.gabekim.domain.tag.repository.TagRepository;
import com.gabekim.entity.Posts;
import com.gabekim.entity.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


// 비즈니스로직처리
@Service
public class PostsServiceImpl implements PostsService{
  
  @Autowired
  PostsRepository postsRepository;

  @Autowired
  TagRepository tagRepository;

  // getPostsDto
  @Override
  public Slice<PostsDto> getPosts(PostsDto postsDto) {

    Direction direction = postsDto.getOrder().equals("asc")  ? Direction.DESC:Direction.ASC;

    Sort sort = Sort.by(direction, postsDto.getField());

    PageRequest pageRequest = PageRequest.of(postsDto.getPage(),postsDto.getSize(),sort);

    Page<Posts> postsEntityList = postsRepository.findAll(pageRequest);

    List<PostsDto> postsDtoList = new PostsMapper().entityListToDtoList(postsEntityList.getContent());

    return new SliceImpl<PostsDto>(postsDtoList,postsEntityList.getPageable(),postsEntityList.hasNext());
  }

  @Override
  public Integer postPosts(PostsDto postsDto) {

    try {
      
      List<String> tagList = postsDto.getTagList();
      
      Posts post = Posts.builder().title(postsDto.getTitle()).postsInfo(postsDto.getInfo()).categoryNo(postsDto.getCategory()).build();
  
      Posts resultPost = postsRepository.save(post);
  
      List<Tag> tagEntityList = new ArrayList<Tag>() {
        {
          for(String tag:tagList){
            Tag tagItem = Tag.builder().postsNo(resultPost.getPostsNo()).tagName(tag).build();
            add(tagItem);
          }
        }
      };
      
      tagRepository.saveAll(tagEntityList);

    }  catch(Error error){
      return 0;
    }

    return 1;
  }

  @Override
  public String putPosts(PostsDto postsDto) {
    return null;
  }

  @Override
  public Integer deletePosts(int postsNo) {
    return null;
  }

}
