package com.ksga.jpademo.controller;

import com.ksga.jpademo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

}
