package com.example.demo.simplestudent;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(
        name = "simple_students",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_email_simple_students", columnNames = "email")
        })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstname;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastname;

    @Column( nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(columnDefinition = "SMALLINT")
    private Integer age;
}
