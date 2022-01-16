package main.service;

import main.domain.*;
import main.controller.request.ArticleDTO;
import main.exception.ServiceException;
import main.repository.AdministratorRepository;
import main.repository.ArticleRepository;
import main.repository.StudentRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    private ArticleRepository articleRepository;
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private AdministratorRepository administratorRepository;
    @Autowired
    public ArticleService(ArticleRepository articleRepository,UserRepository userRepository,StudentRepository studentRepository,AdministratorRepository administratorRepository) throws ServiceException {
        this.articleRepository = articleRepository;
        this.userRepository=userRepository;
        this.studentRepository=studentRepository;
        this.administratorRepository=administratorRepository;
/*
        addArticle(new ArticleDTO("string","string","string","b"));*/
    }

    @Override
    public List<Article> getArticlesBySection(String section) throws ServiceException {
        List<Article> articles = articleRepository.getArticleBySubject(section);

        if (articles.isEmpty()){
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "No articles available for this section");
        }
        return articles;
    }

    public String addArticle(ArticleDTO articleDTO) throws ServiceException {
        User user = userRepository.getByEmail(articleDTO.getAuthor());
        Article a;
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Optional<Student> student = studentRepository.findByUser(user);

        if(student.isPresent()){
            a = new Article(articleDTO.getTitle(), articleDTO.getText(),sqlDate,articleDTO.getSubject(),user, ArticleStatus.PENDING);
            articleRepository.save(a);
            return "Succes";
        }

        Optional<Administrator> administrator = administratorRepository.findByUser(user);

        if(administrator.isPresent()){
            a = new Article(articleDTO.getTitle(), articleDTO.getText(), sqlDate, articleDTO.getSubject(), user, ArticleStatus.APPROVED);
            articleRepository.save(a);
            return "Succes";
        }

        throw new ServiceException(ServiceException.ErrorCode.INTERNAL,"Invalid e-mail");
    }
}
