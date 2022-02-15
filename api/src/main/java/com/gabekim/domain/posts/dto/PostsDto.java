package com.gabekim.domain.posts.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostsDto {

  private String title; //제목
  private int category;//카테고리
  private String info; //정보
  private String[] tagList; //태그
  private Date regDate; //날짜
  private String thumbnail; //썸네일

}