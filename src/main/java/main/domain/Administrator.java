package main.domain;

import javax.persistence.*;

@Entity
@Table(name = "administrators")
public class Administrator {

    @Id
    @JoinColumn(name = "user", referencedColumnName = "email")
    private String email;

    public Administrator() {
    }

    public Administrator(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
