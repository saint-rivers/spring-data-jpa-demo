package com.ksga.jpademo.service;

import com.ksga.jpademo.model.dto.BookDto;
import com.ksga.jpademo.model.request.BookRequest;
import com.ksga.jpademo.repository.AuthorRepository;
import com.ksga.jpademo.repository.BookRepository;
import com.ksga.jpademo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookDto findById(Long bookId) {
        var book = bookRepository.findById(bookId);
        if (book.isPresent()){
            return book.get().toDto();
        }
        throw new NoSuchElementException("book not found");
    }

    @Override
    public BookDto create(BookRequest bookRequest) {
        var book = bookRequest.toEntity();

        // find author by id
        var author = authorRepository.findById(bookRequest.getAuthorId());

        // find all categories
        var categories = categoryRepository
                .findAllById(bookRequest.getCategoryIds());

        // set author to book
        book.setAuthor(author.get());
        // set category to book
        book.setBookCategory(categories);

        return bookRepository.save(book).toDto();
    }
}
