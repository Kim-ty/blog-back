package com.gabekim.domain.posts.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.gabekim.entity.Posts;
import com.gabekim.entity.Tag;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostsDto {

  private String title; //제목
  private int category;//카테고리
  private String info; //정보
  private List<String> tagList; //태그
  private Date regDate; //날짜
  private String thumbnail; //썸네일
  private int size = 5; // limit
  private int page = 0; // 페이지
  private String field = "regDate"; //정렬
  private String order = "Desc"; //정렬 방식

  public PostsDto(Posts entity){
    this.title = entity.getTitle();
    this.category = entity.getCategoryNo();
    this.info = entity.getPostsInfo();

    this.tagList = new ArrayList<>();

    for(Tag tag:entity.getTagList()){
      this.tagList.add(tag.getTagName());
    }

    this.regDate = entity.getRegDate();

  }


}