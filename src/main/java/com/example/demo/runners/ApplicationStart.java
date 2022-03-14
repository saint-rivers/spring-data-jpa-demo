package com.example.demo.runners;

import com.example.demo.classroom.Classroom;
import com.example.demo.classroom.ClassroomRepository;
import com.example.demo.contact.Contact;
import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Order(2)
public class ApplicationStart implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;
    private final CourseRepository courseRepository;

    public ApplicationStart(StudentRepository studentRepository, ClassroomRepository classroomRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
        this.courseRepository = courseRepository;
    }

    public void initCourses() {
        List<Course> courses = new ArrayList<>() {{
            add(new Course(null, "Data Analysis", "Analyze data using Python, SQL and R programming", 0.0));
            add(new Course(null, "Blockchain", "Learn public and private blockchain.", 0.0));
            add(new Course(null, "DevOps", "Auto-deploy and manage websites.", 0.0));
        }};
        courseRepository.saveAll(courses);
    }

    public void initClasses() {
        List<Classroom> classes = new ArrayList<>() {{
            add(new Classroom(null, "PP", 2));
            add(new Classroom(null, "SR", 2));
            add(new Classroom(null, "BTB", 2));
            add(new Classroom(null, "KPS", 1));
        }};
        classroomRepository.saveAll(classes);
    }

    @Override
    public void run(String... args) {
        initClasses();
        initCourses();

        Classroom tmpClass = classroomRepository.findByName("SR");
        Course blockchain = courseRepository.findByName("Blockchain");
        Student newStudent = new Student(null, "Dayan", "Eam", "eam.dayan@gmail.com", 21, new Contact(null, "068400567", "phnom penh"), tmpClass, Collections.singletonList(blockchain));
        studentRepository.save(newStudent);
    }
}
