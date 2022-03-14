package com.gabekim.api.postsTest;


import com.gabekim.api.common.CustomMockRequest;
import com.gabekim.domain.posts.dto.PostsDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostsControllerTest {

    @Autowired(required = true)
    private MockMvc mvc;

    @Autowired
    private CustomMockRequest mockReq;

    @Test
    public void getPosts() throws Exception {

        HashMap<String, String> param = new HashMap<>();

        param.put("page", "1");
        param.put("size", "6");

        MockHttpServletRequestBuilder req = mockReq.get("/posts", param);

        mvc.perform(req).andExpect(status().isOk()).andDo(print());

    }

}
