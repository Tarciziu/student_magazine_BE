package main.controller.response;

import java.util.Date;

public class CommentResponse {
    String autor;
    String text;
    Date date;
    public CommentResponse()
    {

    }

    public String getAutor() {
        return autor;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
