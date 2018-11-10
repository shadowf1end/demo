package com.example.demo.service;

import com.example.demo.dao.DocumentDao;
import com.example.demo.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentDao documentDao;

    @Autowired
    public DocumentService(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public List<Document> list(Integer page, Integer size) {
        return documentDao.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createTime", "updateTime"))).getContent();
    }

    public List<Document> listByNodeId(Integer nodeId, Integer page, Integer size) {
        return documentDao.findAllByNodeId(nodeId, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createTime", "updateTime")));
    }
}
