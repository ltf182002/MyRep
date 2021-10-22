package com.turing.sb002.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author 长沙图灵科技学院
 * @Company www.tulingedu.com
 */

@Entity
@Table(name = "dept")
@Data
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deptno")
    private int deptno;

    @Column(name = "dname")
    private String dname;

    //省略不写
    private String loc;

}
