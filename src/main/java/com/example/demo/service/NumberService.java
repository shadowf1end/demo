package com.example.demo.service;

import com.example.demo.dao.NumberDao;
import com.example.demo.entity.Number;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    private final NumberDao numberDao;

    @Autowired
    public NumberService(NumberDao numberDao) {
        this.numberDao = numberDao;
    }

    public List<Number> findFirst() {
        return numberDao.findAll();
    }
}
