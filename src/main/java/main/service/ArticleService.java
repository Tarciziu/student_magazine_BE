package main.service;

import main.domain.Article;
import main.domain.Student;
import main.domain.User;
import main.domain.dto.ArticleDTO;
import main.exception.ServiceException;
import main.repository.ArticleRepository;
import main.repository.StudentRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    @Autowired
    public ArticleService(ArticleRepository articleRepository,UserRepository userRepository,StudentRepository studentRepository) throws ServiceException {
        this.articleRepository = articleRepository;
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
        addArticle(new ArticleDTO(0,"a","b","c","d","r"));
    }

    @Override
    public List<Article> getArticlesBySection(String section) throws ServiceException {
        List<Article> articles = articleRepository.getArticleBySubject(section);

        if (articles.isEmpty()){
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "No articles available for this section");
        }
        return articles;
    }

    @Transactional
    public ArticleDTO addArticle(ArticleDTO articleDTO) throws ServiceException {
        Optional<User> user=userRepository.findById(articleDTO.getAuthor());
        Article a;
        if(user.isEmpty()){
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL,"Invalid e-mail");
        }
        Date date=Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Optional<Student> student=studentRepository.findById(user.get().getEmail());
        if(student.isEmpty()){
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL,"Invalid e-mail");
        }

/*            a=new Article(articleDTO.getTitle(), articleDTO.getText(),sqlDate,articleDTO.getSubject(),articleDTO.getAuthor())*/


        return articleDTO;
    }
}
