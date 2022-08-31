package com.ksga.jpademo.model.entities;

import com.ksga.jpademo.model.dto.BookDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Choumy
 * <p>
 * Create a table named "books"
 * fields:
 * id (auto-increment)
 * title
 * description
 */

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    // create one-to-one relationship with Author
    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "author_id")
    private Author author;

    // create one-to-many
    @OneToMany(mappedBy = "book")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> bookCategory;

    public BookDto toDto() {
        return new BookDto(
                this.id,
                this.title,
                this.description,
                this.author.toDto(),
                this.bookCategory.stream()
                        .map(Category::toDto)
                        .collect(Collectors.toList())
        );
    }
}
