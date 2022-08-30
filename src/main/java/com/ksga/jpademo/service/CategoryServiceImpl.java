package com.ksga.jpademo.service;

import com.ksga.jpademo.model.entities.Category;
import com.ksga.jpademo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }
}
