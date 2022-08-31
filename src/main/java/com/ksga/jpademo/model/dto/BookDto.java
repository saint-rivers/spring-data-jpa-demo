package com.ksga.jpademo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private AuthorDto author;
    private List<CategoryDto> bookCategory;

    public BookDto(Long id, String title, String description, AuthorDto author, List<CategoryDto> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.bookCategory = categories;
    }
}
