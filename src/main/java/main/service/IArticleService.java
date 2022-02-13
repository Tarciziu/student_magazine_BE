package main.service;

import main.controller.response.ArticleResponse;
import main.domain.Article;
import main.controller.request.ArticleDTO;
import main.exception.ServiceException;

import java.util.List;

public interface IArticleService {
    List<Article> getArticlesBySection(String section) throws ServiceException;
    ArticleResponse getArticleById(String idStr) throws ServiceException;
    String addArticle(ArticleDTO article) throws ServiceException;
    String approveArticle(int n) throws ServiceException;
}
