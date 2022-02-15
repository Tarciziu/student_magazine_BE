package main.service;

import main.controller.request.ArticleDTO;
import main.controller.request.CommentDTO;
import main.exception.ServiceException;

public interface ICommentService {

    String addComment(CommentDTO commentDTO) throws ServiceException;
}
