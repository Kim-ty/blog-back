package com.gabekim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int tagNo;

  @Column
  private String name;

  @Column(nullable = false)
  private int postsNo;

  @Column
  private Date regDate;

  @Builder
  public Tag(String tagName,int postsNo){
    this.name = tagName;
    this.postsNo = postsNo;
  }


}
