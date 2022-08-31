package com.ksga.jpademo.repository;

import com.ksga.jpademo.model.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    Category findByNameAndYear(String name, String year);

    @Query("select c from Category c where c.year = :year")
//    @Query(nativeQuery = true,
//            value = "select * from categories where year = #{year}}")
    Category findByMyYear(String year);

    List<Category> findAllByNameStartingWith(String name);

    Page<Category> findAllByNameContaining(String name, Pageable pageable);
}
