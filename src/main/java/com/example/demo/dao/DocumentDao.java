package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Document;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDao extends BaseDao<Document, Integer> {
    List<Document> findAllByNodeId(Integer nodeId, Pageable pageable);
}
