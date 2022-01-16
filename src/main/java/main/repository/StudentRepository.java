package main.repository;

import main.domain.Article;
import main.domain.Student;
import main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String>
{
/*    @Query(value = "SELECT s FROM Student s WHERE (s.email = ?1)")
    Student getStudentByEmail(User email);*/
}