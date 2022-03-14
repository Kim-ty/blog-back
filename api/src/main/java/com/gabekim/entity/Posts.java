package com.gabekim.entity;

import java.sql.Date;
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

    @Column
    private String thumbNail;

    @OneToMany
    @JoinColumn(name = "postsNo")
    private List<Tag> tagList = new ArrayList<>();

    @Column(nullable=false,length=100)
    private String title;

    @Column(nullable=false)
    private String detail;

    @Column
    private String thumbName;


    @Column
    private Date regDate;

    @Column
    private Date modifyDate;

    @Column(nullable=false)
    private int categoryNo;

    @Column
    private int enable;

    @Builder
    public Posts(String title,String detail,int categoryNo){
      this.title = title;
      this.detail = detail;
      this.categoryNo = categoryNo;
    };

}