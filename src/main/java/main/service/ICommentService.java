package main.service;

import main.controller.request.ArticleDTO;
import main.controller.request.CommentDTO;
import main.domain.Comment;
import main.exception.ServiceException;

import java.util.List;

public interface ICommentService {

    String addComment(CommentDTO commentDTO) throws ServiceException;
    List<Comment> getCommentsByArticle(int n) throws ServiceException;
}
