package com.gabekim.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postsNo;

    private String thumbnail;


    @OneToMany
    @JoinColumn(name = "postsNo")
    private List<Tag> tagList = new ArrayList<>();

    @Column(nullable=false,length=100)
    private String title;

    @Column(nullable=false)
    private String postsInfo;


    private String regDate;
    private String modifyDate;

    @Column(nullable=false)
    private int categoryNo;

    @Builder
    public Posts(String title,String postsInfo,int categoryNo){
      this.title = title;
      this.postsInfo = postsInfo;
      this.categoryNo = categoryNo;
    };

}