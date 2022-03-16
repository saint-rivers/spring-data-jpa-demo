package com.example.demo.runners;

import com.example.demo.contact.Contact;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class OrphanRemovalRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public OrphanRemovalRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) {
        Student student = new Student(null, "Jon", "Snow", "js@gmail.com", 30,
                new Contact(null, "000111222", "phnom penh"),
                null, null);
        Student savedStudent = studentRepository.save(student);

        savedStudent.setContact(new Contact(null, "012121212", "kompong som"));
        studentRepository.save(savedStudent);
        System.out.println(studentRepository.findAll());

        savedStudent.setContact(new Contact(null, "068777333", "siem reap"));
        studentRepository.save(savedStudent);
        System.out.println(studentRepository.findAll());
    }
}
