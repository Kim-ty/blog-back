package com.gabekim.domain.category.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
  
  private Integer category_no; //카테고리 기본키
  private Integer category_type; //카테고리 타입
  private String categoryName; //카테고리명
  private Integer parentsNo; //상위 카테고리 넘버

}
