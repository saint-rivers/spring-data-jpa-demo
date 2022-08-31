package com.ksga.jpademo.service;


import com.ksga.jpademo.model.dto.CategoryDto;
import com.ksga.jpademo.model.request.CategoryRequest;
import org.springframework.data.domain.Page;



public interface CategoryService {

    CategoryDto fetchById(Long id);

    CategoryDto create(CategoryRequest categoryRequest);

    Page<CategoryDto> fetch(Integer page, Integer size);

    CategoryDto update(Long categoryId, CategoryRequest categoryRequest);

    Boolean delete(Long categoryId);

    CategoryDto findByName(String name);

    CategoryDto findByNameAndYear(String name, String year);
}

