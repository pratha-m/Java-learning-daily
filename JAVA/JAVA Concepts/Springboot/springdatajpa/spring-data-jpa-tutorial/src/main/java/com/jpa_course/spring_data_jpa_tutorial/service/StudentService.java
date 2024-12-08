package com.jpa_course.spring_data_jpa_tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa_course.spring_data_jpa_tutorial.entity.Guardian;
import com.jpa_course.spring_data_jpa_tutorial.entity.Student;
import com.jpa_course.spring_data_jpa_tutorial.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public void saveStudent() {
      Guardian guardian=Guardian
      .builder()
      .name("Guard2 name")
      .email("guard2 emaul")
      .mobile("guard2 mobile")
      .build();  

      Student student=Student
      .builder()
      .firstName("stud2 first")
      .lastName("stud2 last")
      .emailId("stud2 email")
      .guardian(guardian)
      .build();

      studentRepository.save(student);

      System.out.println(student);
    }


    public void printMatchedStudents(String firstName){
      List<Student> students=studentRepository.findByFirstName(firstName);
      System.out.println(students);
    }

    public void printFilteredStudents(String firstName){
      List<Student> students=studentRepository.findByFirstNameContaining(firstName);
      System.out.println(students);
    }

    // public void printStudentsByGuardianName(){
    //   List<Student> students=studentRepository.findByGuardianName("Guard2 name");
    //   System.out.println(students);
    // }

     public void findStudentByEmail(){
      Student student=studentRepository.getStudentByEmailAddress("stud2 email");
      System.out.println(student);
    }
}