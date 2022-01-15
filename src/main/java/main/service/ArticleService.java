package main.service;

import main.domain.Article;
import main.exception.ServiceException;
import main.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Article getArticleById(String idStr) throws ServiceException {
        Long id;

        try{
            id = Long.parseLong(idStr);
        } catch(Exception e) {
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "Invalid article id");
        }

        Optional<Article> article = articleRepository.findById(id);

        System.out.println(article);

        if (article.isEmpty()) {
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "Invalid article id");
        }

        return article.get();
    }

}
