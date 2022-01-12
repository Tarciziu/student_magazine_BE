package main.service;

import main.domain.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getArticlesBySection(String section);
}
