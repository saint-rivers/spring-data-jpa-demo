package com.ksga.jpademo.model.request;

import com.ksga.jpademo.model.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private String name;
    private String year;

    public Category toEntity(){
        return new Category(null, this.name, this.year);
    }

    public Category toEntity(Long id){
        return new Category(id, this.name, this.year);
    }
}
