package com.example.demo.classroom;

import com.example.demo.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classroom {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer floor;

//    // Commented out because of a many-to-one relationship on the other table
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "class_id", foreignKey = @ForeignKey(name = "fk_class_id"))
//    private List<Student> students = new ArrayList<>();
}
