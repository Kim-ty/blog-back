package com.gabekim.api.common;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@Component
public class CustomMockRequest {

    private String urlDefault = "/api";


    @Autowired
    TokenGenerator tokenGenerator;

    /* 인증이 불필요한 get */
    public MockHttpServletRequestBuilder get(String url, HashMap<String, String> param) {

        MultiValueMap<String, String> paramToMultiMap = new LinkedMultiValueMap<>();

        paramToMultiMap.setAll(param);

        return MockMvcRequestBuilders.get(urlDefault + url).params(paramToMultiMap).accept(MediaType.APPLICATION_JSON);

    }

    /* 인증이 필요한 get */
    public MockHttpServletRequestBuilder get(String url, HashMap<String, String> param, AuthVO login) throws SQLException, IOException {

        MultiValueMap<String, String> paramToMultiMap = new LinkedMultiValueMap<>();

        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        paramToMultiMap.setAll(param);

        return MockMvcRequestBuilders.get(urlDefault + url)
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"))
                .params(paramToMultiMap).accept(MediaType.APPLICATION_JSON);

    }


    /* 인증이 불필요한 json post */
    public MockHttpServletRequestBuilder post(String url, HashMap<String, Object> param) {

        JSONObject paramToJson = new JSONObject(param);

        return MockMvcRequestBuilders.post(urlDefault + url).content(paramToJson.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /* 인증이 필요한 json post */
    public MockHttpServletRequestBuilder post(String url, HashMap<String, Object> param, AuthVO login) throws SQLException, IOException {

        JSONObject paramToJson = new JSONObject(param);

        //쿠키에 할당하기 위해 토큰을 발급한다
        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        return MockMvcRequestBuilders.post(urlDefault + url).content(paramToJson.toString())
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /* 인증이 필요한 multipart post */
    public MockHttpServletRequestBuilder post(String url, HashMap<String, String> param, FileInputVO fileInputVO, AuthVO login) throws SQLException, IOException {

        //쿠키에 할당하기 위해 토큰을 발급한다
        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        MultiValueMap<String, String> paramToMultiMap = new LinkedMultiValueMap<>();

        paramToMultiMap.setAll(param);

        return MockMvcRequestBuilders
                .multipart(urlDefault + url).file(fileInputVO.getMockMultipartFile())
                .params(paramToMultiMap)
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest mockHttpServletRequest) {
                        mockHttpServletRequest.setMethod("POST");
                        return mockHttpServletRequest;
                    }
                })
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"));
    }


    /* 인증이 필요없는 json put */
    public MockHttpServletRequestBuilder put(String url, HashMap<String, Object> param) {

        JSONObject paramToJson = new JSONObject(param);

        return MockMvcRequestBuilders.post(urlDefault + url).content(paramToJson.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /* 인증이 필요한 json put */
    public MockHttpServletRequestBuilder put(String url, HashMap<String, Object> param, AuthVO login) throws SQLException, IOException {

        JSONObject paramToJson = new JSONObject(param);

        //쿠키에 할당하기 위해 토큰을 발급한다
        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        return MockMvcRequestBuilders.put(urlDefault + url).content(paramToJson.toString())
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }


    /* 인증이 필요한 multipart put */
    public MockHttpServletRequestBuilder put(String url, HashMap<String, String> param, FileInputVO fileInputVO, AuthVO login) throws SQLException, IOException {

        //쿠키에 할당하기 위해 토큰을 발급한다
        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        MultiValueMap<String, String> paramToMultiMap = new LinkedMultiValueMap<>();

        paramToMultiMap.setAll(param);

        return MockMvcRequestBuilders
                .multipart(urlDefault + url).file(fileInputVO.getMockMultipartFile())
                .params(paramToMultiMap)
                .with(new RequestPostProcessor() {
                    @Override
                    public MockHttpServletRequest postProcessRequest(MockHttpServletRequest mockHttpServletRequest) {
                        mockHttpServletRequest.setMethod("PUT");
                        return mockHttpServletRequest;
                    }
                })
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"));
    }


    /* 인증이 필요한 json put */
    public MockHttpServletRequestBuilder delete(String url, HashMap<String, Object> param) {

        JSONObject paramToJson = new JSONObject(param);

        return MockMvcRequestBuilders.delete(urlDefault + url).content(paramToJson.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }

    /* 인증이 필요한 json put */
    public MockHttpServletRequestBuilder delete(String url, HashMap<String, Object> param, AuthVO login) throws SQLException, IOException {

        JSONObject paramToJson = new JSONObject(param);

        //쿠키에 할당하기 위해 토큰을 발급한다
        HashMap<String, Cookie> cookieMap = tokenGenerator.getUserToken(login);

        return MockMvcRequestBuilders.delete(urlDefault + url).content(paramToJson.toString())
                .cookie(cookieMap.get("accessToken"))
                .cookie(cookieMap.get("refreshToken"))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
    }


}
