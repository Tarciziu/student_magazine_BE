package main.controller;

import main.domain.Article;
import main.exception.ServiceException;
import main.mapper.Mapper;
import main.service.ArticleService;
import main.exception.ServiceException;
import main.controller.request.ArticleDTO;
import main.service.IArticleService;
import main.validator.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {
    IArticleService articleService;
    Mapper mapper;

    @Autowired
    public ArticleController(IArticleService articleService, Mapper mapper) {
        this.articleService = articleService;
        this.mapper = mapper;
    }

    @GetMapping("/section/{section}")
    ResponseEntity getArticlesBySection(@PathVariable String section) {
        try {
            return ResponseEntity.ok().body(
                    articleService.getArticlesBySection(section).stream()
                            .map(article -> mapper.convertToArticleDTO(article)).collect(Collectors.toList())
                    );
        } catch(ServiceException e) {
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

    @GetMapping("/latest/{n}")
    ResponseEntity getLatestArticles(@PathVariable int n) {
        try {
            return ResponseEntity.ok().body(
                    articleService.getLatestArticles(n).stream()
                            .map(article -> mapper.convertToArticleDTO(article)).collect(Collectors.toList())
            );
        } catch(ServiceException e) {
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity createArticle(@RequestBody ArticleDTO article) throws ServiceException {

        try {
            return ResponseEntity.ok().body(articleService.addArticle(article));
        }
        catch(ServiceException e){
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

    @PostMapping("/approve")
    public ResponseEntity approveArticle(@RequestBody int n) throws ServiceException{


        try{
            return ResponseEntity.ok().body(articleService.approveArticle(n));
        }
        catch(ServiceException e){
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    ResponseEntity getArticleById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(articleService.getArticleById(id));
        } catch (ServiceException e) {
            System.out.println("Except");
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }
}
