package main.controller.request;

import javax.validation.constraints.NotNull;

public class CommentDTO {

    @NotNull
    private String author;
    @NotNull
    private String text;
    @NotNull
    private long idArticle;

    public CommentDTO()
    {

    }
    public CommentDTO(@NotNull String author, @NotNull String text, @NotNull long id) {
        this.author = author;
        this.text = text;
        this.idArticle = id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public long getIdArticle() {
        return idArticle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIdArticle(int id) {
        this.idArticle = id;
    }
}
