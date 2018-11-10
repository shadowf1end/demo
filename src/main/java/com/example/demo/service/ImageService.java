package com.example.demo.service;

import com.example.demo.dao.ImageDao;
import com.example.demo.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageDao imageDao;

    @Autowired
    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public List<Image> list() {
        return imageDao.findAll();
    }
}
