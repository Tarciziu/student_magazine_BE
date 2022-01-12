package main.repository;

import main.domain.Article;
import main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> getArticleBySubject(String subject);
}
