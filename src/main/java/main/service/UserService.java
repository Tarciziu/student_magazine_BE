package main.service;

import main.domain.User;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public String login(String email, String password) throws Exception {
        // user login
        // TODO maybe you can search for student or admin too. One login function for all roles
        Optional<User> user = userRepository.findById(email);

        if (user.isEmpty()) {
            throw new Exception("Email or password incorrect"); // TODO replace with ServiceException
        }

        // TODO check password with BCrypt.checkpw(unencrypted_password, encrypted_password_from_db)
        // if (BCrypt.checkpw(oldPassword, user.getPassword()))

        return null;
    }
}
