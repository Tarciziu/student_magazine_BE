package main.controller.request;

import main.domain.Student;

import javax.validation.constraints.NotNull;


public class ArticleDTO {


    @NotNull
    private String title;
    @NotNull
    private String text;

    @NotNull
    private String subject;

    @NotNull
    private String author;


    public ArticleDTO(@NotNull String title, @NotNull String text, @NotNull String subject, @NotNull String author) {
        this.title = title;
        this.text = text;
        this.subject = subject;
        this.author = author;
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
