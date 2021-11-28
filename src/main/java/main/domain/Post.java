package main.domain;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {
    // d.	Postare (titlu, autor, text, data,  subiect)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private Date date;

    @Column(name = "subject")
    private String subject;

    @JoinColumn(name = "students",  referencedColumnName = "email")
    @ManyToOne
    private Student author;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    public Post() {
    }


}
