package com.gabekim.domain.category.controller;

import java.util.ArrayList;

import com.gabekim.domain.category.dto.CategoryDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Category")
public class CategoryController {
  

  @RequestMapping(method = RequestMethod.GET)
  public ArrayList<CategoryDto> getCategory() {
    return null;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String postCategory() {
    return "postsCategory";
  }
  
  @RequestMapping(method = RequestMethod.PUT)
  public String putCategory() {
    return "putCategory";
  }
  
  @RequestMapping(method = RequestMethod.DELETE)
  public String deleteCategory() {
    return "deleteCategory";
  }

}
