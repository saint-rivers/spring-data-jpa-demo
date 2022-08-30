package com.ksga.jpademo.service;

import com.ksga.jpademo.model.entities.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {

    Page<Category> findAll(Integer page, Integer size);
}

