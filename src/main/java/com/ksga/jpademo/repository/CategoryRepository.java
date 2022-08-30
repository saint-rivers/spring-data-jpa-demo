package com.ksga.jpademo.repository;

import com.ksga.jpademo.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}