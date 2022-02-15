package main.controller;

import main.controller.request.ArticleDTO;
import main.controller.request.CommentDTO;
import main.exception.ServiceException;
import main.mapper.Mapper;
import main.service.ICommentService;
import main.validator.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@CrossOrigin
public class CommentController {
    ICommentService commentService;
    Mapper mapper;

    @Autowired
    public CommentController(ICommentService commentService)
    {
        this.commentService=commentService;
    }

    @PostMapping("/add")
    public ResponseEntity createComment(@RequestBody CommentDTO commentDTO) throws ServiceException
    {
        try {
            return ResponseEntity.ok().body(commentService.addComment(commentDTO));
        }
        catch(ServiceException e){
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

}
