package main.controller.response;


import java.util.Date;

public class ArticleResponse {
    Long id;
    String title;
    String authorName;
    String text;
    Date date;

    public ArticleResponse() {
    }

    public ArticleResponse(Long id, String title, String authorName, String text, Date date) {
        this.title = title;
        this.authorName = authorName;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
