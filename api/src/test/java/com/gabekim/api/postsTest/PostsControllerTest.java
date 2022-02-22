package com.gabekim.api.postsTest;


import com.gabekim.api.common.MockTestBuilder;
import com.gabekim.domain.posts.dto.PostsDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostsControllerTest {

    @Autowired(required = true)
    private MockMvc mvc;

   @Test
   public void getPosts() throws Exception{

    PostsDto postsDto = new PostsDto();

    postsDto.setPage(1);
    postsDto.setSize(6);

    MockHttpServletRequestBuilder req = new MockTestBuilder<PostsDto>().get("/posts",postsDto);

    mvc.perform(req).andExpect(status().isOk()).andDo(print());

   }

}
