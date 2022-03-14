package com.gabekim.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeNo;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private Date regDate;

    @Column
    private Date modifyDate;

    @Column
    private int enable;


    @Builder
    public Notice(String title,String detail){
        this.title = title;
        this.detail = detail;
    }

    @Builder
    public Notice(int enable){
        this.enable = enable;
    }

}
