package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Node;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeDao extends BaseDao<Node, Integer> {
    List<Node> findAllByType(Integer type);
    List<Node> findAllByParentId(Integer parentId);
}
