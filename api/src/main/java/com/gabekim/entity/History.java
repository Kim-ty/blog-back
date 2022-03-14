package com.gabekim.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historyNo;

    @Column
    private String info;

    @Column
    private Date regDate;

    @Column
    private Date modifyDate;


    public History(String info){
        this.info = info;
    }

}
