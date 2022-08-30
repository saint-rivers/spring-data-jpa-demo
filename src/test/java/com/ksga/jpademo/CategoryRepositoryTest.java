package com.ksga.jpademo;

import com.ksga.jpademo.model.Category;
import com.ksga.jpademo.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureTestDatabase
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void canInsertCategory(){
        var savedCategory = categoryRepository.save(new Category(null, "drama"));
        System.out.println(savedCategory);
        assertThat(savedCategory.getId()).isEqualTo(1L);
        assertThat(savedCategory.getName()).isEqualTo("drama");
        assertThat(savedCategory.getBook().size()).isEqualTo(0L);
    }
}
