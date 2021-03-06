package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "number")
public class Number {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "download_number")
    private Long downloadNum;
    @Column(name = "document_number")
    private Long docNum;
    @Column(name = "initial_download_number")
    private Long initDownloadNum;
    @Column(name = "initial_document_number")
    private Long initDocNum;
    @Column(name = "share_point")
    private Integer sharePoint;
}
