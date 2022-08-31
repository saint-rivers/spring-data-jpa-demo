package com.ksga.jpademo.service;

import com.ksga.jpademo.model.dto.CategoryDto;
import com.ksga.jpademo.model.entities.Category;
import com.ksga.jpademo.model.request.CategoryRequest;
import com.ksga.jpademo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto fetchById(Long id) {
        var response = categoryRepository.findById(id);

        if (response.isPresent()) return response.get().toDto();
        throw new NoSuchElementException("cannot find category with id " + id);
    }

    @Override
    public CategoryDto create(CategoryRequest categoryRequest) {
        // receive request and convert to jpa entity
        var category = categoryRequest.toEntity();
        // save
        var savedCategory = categoryRepository.save(category);
        // convert to dto then return
        return savedCategory.toDto();
    }

    @Override
    public Page<CategoryDto> fetch(Integer page, Integer size) {
        // create page request
        var pageRequest = PageRequest.of(page, size);

        var result = categoryRepository.findAll(pageRequest);

        return result.map(Category::toDto);
    }

    @Override
    public CategoryDto update(Long categoryId, CategoryRequest categoryRequest) {
        // check if category exists
        var cat = categoryRepository.findById(categoryId);
        // if not null, update
        if (cat.isPresent()) {
            var catEntity = categoryRequest.toEntity(0L);
            System.out.println(catEntity);
            return categoryRepository
                    .save(catEntity)
                    .toDto();
        }
        throw new NoSuchElementException("category not found");
    }

    @Override
    public Boolean delete(Long categoryId) {
        // shortcut
//        categoryRepository.deleteById(categoryId);

        // find category
        var cat = categoryRepository.findById(categoryId);
        if (cat.isPresent()) {
            categoryRepository.delete(cat.get());
            return true;
        }
        throw new NoSuchElementException("category not found");
    }

    @Override
    public CategoryDto findByName(String name) {
        return categoryRepository.findByName(name).toDto();
    }

    @Override
    public CategoryDto findByNameAndYear(String name, String year) {
        return categoryRepository.findByNameAndYear(name, year).toDto();
    }
}
