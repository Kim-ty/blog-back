package com.gabekim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryNo;

    @Column(nullable = false)
    private Integer categoryType;

    @Column(columnDefinition = "TEXT")
    private String categoryName;

    @Column
    private Integer parentsNo;

    @Column
    private Integer categoryOrder;

    @Builder
    public Category(Integer categoryType,String categoryName,int parentsNo){
        this.categoryType = categoryType;
        this.categoryName = categoryName;
        this.parentsNo = parentsNo;
    }

}
