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
            Student student_1 = new Student("Student1", "1", "student1@nobody.com", 21);
            Student student_2 = new Student("Student2", "2", "student2@nobody.com", 21);
            Student student_3 = new Student("Student3", "3", "student3@nobody.com", 21);
            Student student_4 = new Student("Student4", "4", "student4@nobody.com", 21);

            studentRepository.saveAll(List.of(john_doe, jane_doe, student_1, student_2, student_3, student_4));
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

            studentRepository
                    .findStudentByEmail("janedoe@nobody.com")
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Student with email not found"));

            studentRepository
                    .findStudentByEmail("unknown@email.com")
                    .ifPresentOrElse(System.out::println, () -> System.out.println("Student with email not found"));

            System.out.println(studentRepository.countByLastName("Doe"));

            studentRepository
                    .findStudentsByFirstNameAndAgeEquals("Student1", 21)
                    .forEach(System.out::println);

            studentRepository
                    .findByLastNameAndAgeOrderByFirstNameAsc("Student3", 21)
                    .forEach(System.out::println);

            studentRepository
                    .findByEmailContaining("student")
                    .forEach(System.out::println);

            studentRepository
                    .findByAgeLessThanEqual(30)
                    .forEach(System.out::println);

            studentRepository
                    .findByLastNameOrderByLastNameAsc("Doe")
                    .forEach(System.out::println);

            studentRepository
                    .findByAgeBetween(20, 21)
                    .forEach(System.out::println);
        };
    }
}
