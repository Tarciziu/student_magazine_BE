package main.service;

public interface IUserService {
    String login(String email, String password) throws Exception;
}
