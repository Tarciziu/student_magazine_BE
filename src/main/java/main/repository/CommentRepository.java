package main.repository;

import main.domain.Article;
import main.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value="SELECT c FROM Comment c WHERE (c.article.id=?1) ORDER BY c.date")
    List<Comment> getCommentByArticle(long n);
}
