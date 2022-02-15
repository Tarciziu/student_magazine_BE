package main.service;

import com.mysql.cj.jdbc.exceptions.SQLError;
import main.controller.request.ArticleDTO;
import main.controller.request.CommentDTO;
import main.domain.Article;
import main.domain.Comment;
import main.domain.User;
import main.exception.ServiceException;
import main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CommentService implements ICommentService{

    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private AdministratorRepository administratorRepository;
    private CommentRepository commentRepository;


    @Autowired
    public CommentService(ArticleRepository articleRepository, UserRepository userRepository, StudentRepository studentRepository, AdministratorRepository administratorRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.administratorRepository = administratorRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public String addComment(CommentDTO commentDTO) throws ServiceException {
        try
        {
        User user = userRepository.getByEmail(commentDTO.getAuthor());
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Article a=articleRepository.getById(commentDTO.getIdArticle());
        Comment comment=new Comment(user,a,sqlDate,commentDTO.getText());
        commentRepository.save(comment);
        return "S-a adaugat comentariul!";
        }catch(Exception e)
        {
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL,"Nu a reusit adaugarea");
        }
    }
}
