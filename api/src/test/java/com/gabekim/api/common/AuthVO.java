package com.gabekim.api.common;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthVO {

    private String id;
    private String pw;

    public AuthVO(String id,String pw){
        this.id = id;
        this.pw = pw;
//        this.pw = CommonUtils.SHA256(id + pw, "SHA-256");
    }

}
