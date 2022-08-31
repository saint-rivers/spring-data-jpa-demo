package com.ksga.jpademo.repository;

import com.ksga.jpademo.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}