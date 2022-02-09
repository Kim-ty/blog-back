package com.gabekim.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Category {
    
    @Id
    private Integer category_no;

    @Column(nullable = false)
    private Integer category_type;

    @Column(columnDefinition = "TEXT")
    private String category_name;

    @Column
    private Integer parents_no;

    @Builder
    public Category(Integer category_type,String category_name,int parents_no){
        
    }

}
