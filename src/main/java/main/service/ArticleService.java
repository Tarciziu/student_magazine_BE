package main.service;

import main.domain.Article;
import main.exception.ServiceException;
import main.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IArticleService {
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getArticlesBySection(String section) throws ServiceException {
        List<Article> articles = articleRepository.getArticleBySubject(section);

        if (articles.isEmpty()){
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "No articles available for this section");
        }
        return articles;
    }
}
