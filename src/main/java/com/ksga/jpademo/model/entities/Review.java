package com.ksga.jpademo.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Teklim
 * <p>
 * table: "reviews"
 * fields:      id (auto-increment)
 * caption (string)
 * rating
 * <p>
 * created_at (timestamp)(LocalDateTime)
 */


@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String caption;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "book_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "book_fk")
    )
    private Book book;
}
