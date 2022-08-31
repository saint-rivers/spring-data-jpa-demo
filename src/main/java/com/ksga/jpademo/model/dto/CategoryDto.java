package com.ksga.jpademo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private String year;
}
