package com.ksga.jpademo.service;


import com.ksga.jpademo.model.dto.BookDto;
import com.ksga.jpademo.model.request.BookRequest;

public interface BookService {

    BookDto findById(Long bookId);

    BookDto create(BookRequest bookRequest);
}
