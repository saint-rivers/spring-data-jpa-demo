package com.ksga.jpademo.controller;

import com.ksga.jpademo.model.response.ApiResponse;
import com.ksga.jpademo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        var response = new ApiResponse.SuccessPayload<>(
                "asd",
                "200",
                categoryService.findAll(page - 1, size).getContent()
        );
        return ResponseEntity.ok(response);
    }
}
