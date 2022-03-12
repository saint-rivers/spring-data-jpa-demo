package com.example.demo.student;

import com.example.demo.classroom.Classroom;
import com.example.demo.contact.Contact;
import com.example.demo.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contact_id", foreignKey = @ForeignKey(name = "fk_contact_id"))
    private Contact contact;

    // a many-to-one relationship makes more sense here
    // we will likely create a classroom on it's own
    // then create students and assign them to their classes
    // any students we create afterwards, we'll just insert a pre-existing classroom
    // many-to-one here will create a different table and we do not need to create a list
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "class_id", foreignKey = @ForeignKey(name = "fk_class_id"))
    private Classroom classroom;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "fk_course_id")),
            inverseJoinColumns = @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_student_id"))
    )
    private List<Course> courses = new ArrayList<>();

}
