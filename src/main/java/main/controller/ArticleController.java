package main.controller;

import main.domain.Article;
import main.service.ArticleService;
import main.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    IArticleService articleService;

    @Autowired
    public ArticleController(IArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{section}")
    ResponseEntity<List<Article>> getArticlesBySection(@PathVariable String section) {
        return ResponseEntity.ok().body(articleService.getArticlesBySection(section));
    }
}
