package com.springboot.springdatajpa;

import com.springboot.springdatajpa.entity.Student;
import com.springboot.springdatajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student john_doe = new Student("John", "Doe", "johndoe@nobody.com", 21);
            Student jane_doe = new Student("Jane", "Doe", "janedoe@nobody.com", 22);

            studentRepository.saveAll(List.of(john_doe, jane_doe));
            System.out.println(studentRepository.count());

            studentRepository
                    .findById(2L)
                    .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Student with ID 2 not found"));

            studentRepository
                    .findById(3L)
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student with ID 3 not found"));

            List<Student> students = studentRepository.findAll();
            students.forEach(System.out::println);

            studentRepository.deleteById(1L);
            System.out.println(studentRepository.count());
        };
    }
}
