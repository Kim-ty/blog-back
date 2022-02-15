package com.gabekim.domain.category.service;

import java.util.ArrayList;

import com.gabekim.domain.category.dto.CategoryDto;

public interface CategoryService {

  public ArrayList<CategoryDto> getCategory();

  public Integer postCategory();

  public String putPosts();

  public Integer deletePosts();

}
