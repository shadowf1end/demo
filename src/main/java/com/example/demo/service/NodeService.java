package com.example.demo.service;

import com.example.demo.dao.NodeDao;
import com.example.demo.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {

    private final NodeDao nodeDao;

    @Autowired
    public NodeService(NodeDao nodeDao) {
        this.nodeDao = nodeDao;
    }

    public List<Node> listByParentId(Integer parentId) {
        return nodeDao.findAllByParentId(parentId);
    }

    public List<Node> listByType(Integer type) {
        return nodeDao.findAllByType(type);
    }
}
