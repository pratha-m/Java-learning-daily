package com.jpa_course.spring_data_jpa_tutorial.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jpa_course.spring_data_jpa_tutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String firstName);
    // public List<Student> findByLastNameNotNull(String lastName);
    // public List<Student> findByGuardianName(String guardianName);

    // JPQL
    @Query("select s from Student s where s.email_address=?1")
    Student getStudentByEmailAddress(String EmailId);
}