package main.domain;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @JoinColumn(name = "user", referencedColumnName = "email")
    private String email;

    @Column(name = "university")
    private String university;

    public Student() {
    }

    public Student(String email, String university) {
        this.email = email;
        this.university = university;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
