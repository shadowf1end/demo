package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Document;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDao extends BaseDao<Document, Integer> {
}
