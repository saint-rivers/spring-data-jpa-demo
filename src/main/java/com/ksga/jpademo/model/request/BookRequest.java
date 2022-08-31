package com.ksga.jpademo.model.request;

import com.ksga.jpademo.model.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest implements Serializable {
    private String title;
    private String description;
    private Integer authorId;
    private List<Long> categoryIds;

    public Book toEntity(){
        var book = new Book();
        book.setTitle(this.title);
        book.setDescription(this.description);
        return book;
    }
}
