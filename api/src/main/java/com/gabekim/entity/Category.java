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
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryNo;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column
    private int parentsNo;

    @Column
    private int categoryOrder;

    @Column
    private Date regDate;

    @Column
    private int enable;

    @Builder
    public Category(String title,int parentsNo,int categoryOrder){
        this.title = title;
        this.parentsNo = parentsNo;
        this.categoryOrder = categoryOrder;
    }

}
