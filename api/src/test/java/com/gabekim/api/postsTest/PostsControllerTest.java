package com.gabekim.api.postsTest;

import com.gabekim.domain.posts.controller.PostsController;
import com.gabekim.domain.posts.dto.PostsDto;
import com.gabekim.domain.posts.service.PostsService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Slice;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostsController.class)
public class PostsControllerTest {

  private MockMvc mvc;

  @MockBean private PostsService postsService;


  // @Test
  // public void getPosts(){

  //   PostsDto postsDto = new PostsDto();

  //   Slice<PostsDto> response =  postsController.getPosts(postsDto);

  //   System.out.println(response);

  // }

}
