package com.jpa_course.spring_data_jpa_tutorial.repository;

import com.jpa_course.spring_data_jpa_tutorial.entity.Guardian;
import com.jpa_course.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
  @Autowired
   private StudentRepository studentRepository;

   @Test
   public void saveStudent() {
      Guardian guardian=Guardian
      .builder()
      .name("Guard1 name")
      .email("guard1 emaul")
      .mobile("guard1 mobile")
      .build();  

      Student student=Student
      .builder()
      .firstName("stud1 first")
      .lastName("stud1 last")
      .emailId("stud1 email")
      .guardian(guardian)
      .build();
    }

}