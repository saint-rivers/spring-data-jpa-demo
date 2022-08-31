package com.ksga.jpademo.controller;

import com.ksga.jpademo.model.dto.BookDto;
import com.ksga.jpademo.model.request.BookRequest;
import com.ksga.jpademo.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public BookDto find(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping
    public BookDto create(@RequestBody BookRequest bookRequest){
        return bookService.create(bookRequest);
    }
}
