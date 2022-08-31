package com.ksga.jpademo.controller;

import com.ksga.jpademo.model.dto.CategoryDto;
import com.ksga.jpademo.model.request.CategoryRequest;
import com.ksga.jpademo.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Data
@NoArgsConstructor
class PageResponse<T> {
    private Integer totalPages;
    private Long totalElements;
    private T payload;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class SuccessResponse {
    private String message;
    private String status;
}

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public PageResponse<?> fetchAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        var payload = categoryService.fetch(page - 1, size);

        var res = new PageResponse<>();
        res.setPayload(payload.getContent());
        res.setTotalPages(payload.getTotalPages());
        res.setTotalElements(payload.getTotalElements());
        return res;
    }

    @GetMapping("/{id}")
    public CategoryDto fetchById(@PathVariable Long id) {
        return categoryService.fetchById(id);
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.create(categoryRequest);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@RequestBody CategoryRequest categoryRequest, @PathVariable Long id) {
        return categoryService.update(id, categoryRequest);
    }

    @DeleteMapping("/{id}")
    public SuccessResponse delete(@PathVariable Long id) {
        categoryService.delete(id);
        return new SuccessResponse(
                "deleted category successfully",
                "200"
        );
    }

    @GetMapping("/name/{name}")
    public CategoryDto findByName(@PathVariable String name){
        return categoryService.findByName(name);
    }

    @GetMapping("/search")
    public CategoryDto findByName(
            @RequestParam String name,
            @RequestParam String year
    ){
        return categoryService.findByNameAndYear(name, year);
    }
}
