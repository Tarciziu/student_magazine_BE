package main.service;

import main.domain.User;
import main.exception.ServiceException;

import java.sql.Date;

public interface IUserService {
    String register(User user) throws ServiceException;
    String login(String email, String password) throws ServiceException;
    User getByEmail(String email) throws ServiceException;
}
