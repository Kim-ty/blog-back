package com.gabekim.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;

    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private String picture;

    @Column
    private String simpleInfo;

    @Column
    private String info;

    @Column
    private String regDate;

    @Column
    private String email;

    @Column
    private String github;

    @Column
    private String instargram;



    @Builder
    public Profile(int userNo,String simpleInfo,String info,String picture,String email,String github,String instargram){
        this.userNo = userNo;
        this.info = info;
        this.simpleInfo = simpleInfo;
        this.picture = picture;
        this.email = email;
        this.github = github;
        this.instargram = instargram;
    }

}
