package main.repository;

import main.domain.Article;
import main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT a FROM Article a WHERE (a.status = 'APPROVED' AND a.subject = :subject) ORDER BY a.id DESC")
    List<Article> getArticleBySubject(@Param("subject") String subject);
    @Transactional
    @Modifying
    @Query(value="UPDATE Article a SET a.status='APPROVED' WHERE a.id=?1")
    void approveArticle(long n);

    @Query(value="SELECT a FROM Article a WHERE (a.status='APPROVED') ORDER BY a.id DESC")
    List<Article> getLatestArticle();
}
