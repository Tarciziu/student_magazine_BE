package main.service;

import main.domain.User;
import main.exception.ServiceException;

import java.sql.Date;

public interface IUserService {
    String login(String email, String password);
    String register(User user) throws ServiceException;
}
