package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Number;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberDao extends BaseDao<Number, Integer> {
}
