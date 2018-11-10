package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Node;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeDao extends BaseDao<Node, Integer> {
}
