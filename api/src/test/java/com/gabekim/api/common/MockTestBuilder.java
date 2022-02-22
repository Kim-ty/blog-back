package com.gabekim.api.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;


public class MockTestBuilder<T> {

    public MockHttpServletRequestBuilder get(String url,T param){

        ObjectMapper objectMapper = new ObjectMapper();





        Map<String,String> paramMap = objectMapper.convertValue(param, Map.class);

        MultiValueMap<String,String> paramToJson = new LinkedMultiValueMap<>();

        for(Map.Entry<String,String> entry: paramMap.entrySet()){

            if(entry.getValue() != null) {
                String key = entry.getKey();
                String value = String.valueOf(entry.getValue());

                paramToJson.set(key, value);
            }
        }

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get(url).params(paramToJson).accept(MediaType.APPLICATION_JSON);


        return req;

    }



}
