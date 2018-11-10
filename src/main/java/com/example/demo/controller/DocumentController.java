package com.example.demo.controller;

import com.example.demo.common.vo.ResultMap;
import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("document")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public ResultMap list(Integer nodeId, Integer page, Integer size) {
        if (page == null || size == null) {
            page = 0;
            size = 10;
        }
        List<Document> data;
        if(nodeId == null) {
             data = documentService.list(page, size);
        } else {
            data = documentService.listByNodeId(nodeId, page, size);
        }
        return ResultMap.ok().put("data", data);
    }
}
