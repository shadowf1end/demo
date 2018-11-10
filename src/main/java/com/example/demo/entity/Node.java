package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "node")
public class Node {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "type")
    private Integer type;
}
