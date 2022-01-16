package main.controller;

import main.exception.ServiceException;
import main.controller.request.ArticleDTO;
import main.service.IArticleService;
import main.validator.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    IArticleService articleService;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{section}")
    ResponseEntity getArticlesBySection(@PathVariable String section) {
        try {
            return ResponseEntity.ok().body(articleService.getArticlesBySection(section));
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



}
