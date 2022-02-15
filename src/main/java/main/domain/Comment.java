package main.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @JoinColumn(name = "user",  referencedColumnName = "email")
    @ManyToOne
    private User user;

    @JoinColumn(name="article", referencedColumnName = "id")
    @ManyToOne
    private Article article;
    @Column(name = "date")
    private Date date;
    @Column(name="text")
    private String text;

    public Comment() {

    }
    public Comment(User user, Article article, Date date,String text) {
        this.user = user;
        this.article = article;
        this.date = date;
        this.text=text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public String getText(){
        return text;
    }

    void  setText(){
        this.text=text;
    }

    public Article getArticle() {
        return article;
    }

    public Date getDate() {
        return date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
