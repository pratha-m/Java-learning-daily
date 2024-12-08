package com.jpa_course.spring_data_jpa_tutorial.Controllers;
import org.springframework.web.bind.annotation.RestController;

import com.jpa_course.spring_data_jpa_tutorial.entity.Student;
import com.jpa_course.spring_data_jpa_tutorial.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/save")
    public void saveStudent() {
        studentService.saveStudent();
    }

    @PostMapping("/match-firstname")
    public void printMatchedStudents(@RequestBody Student student) {
        studentService.printMatchedStudents(student.getFirstName());
    }

    @PostMapping("/contains-firstname")
    public void printFilteredStudents(@RequestBody Student student) {
        studentService.printFilteredStudents(student.getFirstName());
    }

    // @GetMapping("/find-guard-name")
    // public void printStudentsByGuardianName() {
    //     studentService.printStudentsByGuardianName();
    // }


    @GetMapping("/find-by-email")
    public void findStudentByEmail() {
        studentService.findStudentByEmail();
    }
}
