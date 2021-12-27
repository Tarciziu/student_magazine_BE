package main.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "articles")
public class Article {

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
    private ArticleStatus status;

    public Article() {
    }


}
