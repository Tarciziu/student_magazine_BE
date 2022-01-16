package main.domain.dto;

import main.domain.Student;

import javax.validation.constraints.NotNull;


public class ArticleDTO {


    private Integer id;
    @NotNull
    private String title;
    @NotNull
    private String text;

    @NotNull
    private String subject;

    @NotNull
    private String author;
    @NotNull
    private String status;

    public ArticleDTO(Integer id, @NotNull String title, @NotNull String text, @NotNull String subject, @NotNull String author, @NotNull String status) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.subject = subject;
        this.author = author;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }



    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public ArticleDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
