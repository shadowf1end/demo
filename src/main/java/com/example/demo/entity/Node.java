package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "node")
public class Node {
    private Integer id;
    private String title;
}
