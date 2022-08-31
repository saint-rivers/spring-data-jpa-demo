package com.ksga.jpademo.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * @author Choumy
 *
 * Create a table named "books"
 * fields:
 *      id (auto-increment)
 *      title
 *      description
 */

@Entity
@Table(name = "books")
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
    @JoinTable(name = "book_category" ,
            joinColumns =@JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> bookCategory;
}
