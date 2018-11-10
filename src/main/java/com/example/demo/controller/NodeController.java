package com.example.demo.controller;

import com.example.demo.common.vo.ResultMap;
import com.example.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("node")
public class NodeController {

    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @RequestMapping(value = "parents", method = RequestMethod.GET)
    public ResultMap listParents() {
        return ResultMap.ok().put("data", nodeService.listByType(1));
    }

    @RequestMapping(value = "{parentId}", method = RequestMethod.GET)
    public ResultMap listByParentId(@PathVariable Integer parentId) {
        return ResultMap.ok().put("data", nodeService.listByParentId(parentId));
    }
}
