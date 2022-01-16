package main.service;

import main.domain.Article;
import main.controller.request.ArticleDTO;
import main.exception.ServiceException;

import java.util.List;

public interface IArticleService {
    List<Article> getArticlesBySection(String section) throws ServiceException;
    String addArticle(ArticleDTO article) throws ServiceException;
}
