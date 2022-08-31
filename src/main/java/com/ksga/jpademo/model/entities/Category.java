package com.ksga.jpademo.model.entities;

import com.ksga.jpademo.model.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachakyarith
 *
 * Create a table named "categories"
 * fields:  id (auto-increment)
 *          name (unique, not null)
 */

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String year;

    @ManyToMany(mappedBy = "bookCategory")
    private List<Book> book = new ArrayList<>();

    public Category(Long id, String name, String year) {
        this.name = name;
        this.id = id;
        this.year = year;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }


    public CategoryDto toDto(){
        return new CategoryDto(this.id, this.name, this.year);
    }
}
