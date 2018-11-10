package com.example.demo.controller;

import com.example.demo.common.vo.ResultMap;
import com.example.demo.entity.Number;
import com.example.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("number")
public class NumberController {

    private final NumberService numberService;

    @Autowired
    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultMap get() {
        List<Number> list = numberService.findFirst();
        Number number = list.get(0);
        return ResultMap.ok().put("docNum", number.getDocNum() + number.getInitDocNum()).put("downLoadNum", number.getInitDownloadNum());
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ResultMap download() {
        Number number = numberService.findFirst().get(0);
        number.setDownloadNum(number.getDownloadNum() + 1);
        return ResultMap.ok();
    }
}
