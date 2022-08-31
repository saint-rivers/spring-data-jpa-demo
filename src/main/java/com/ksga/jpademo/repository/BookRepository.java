package com.ksga.jpademo.repository;

import com.ksga.jpademo.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}