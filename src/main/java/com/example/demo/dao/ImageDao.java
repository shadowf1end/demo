package com.example.demo.dao;

import com.example.demo.base.BaseDao;
import com.example.demo.entity.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDao extends BaseDao<Image, Integer> {
}
