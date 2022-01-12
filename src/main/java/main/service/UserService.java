package main.service;

import main.domain.User;
import main.exception.ServiceException;
import main.repository.UserRepository;
import main.validator.UserValidator;
import main.validator.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;
    Encryptor encryptor;

    @Autowired
    UserService(UserRepository userRepository, UserValidator userValidator, Encryptor encryptor){
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.encryptor = encryptor;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public String register(User user) throws ServiceException {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new ServiceException(ServiceException.ErrorCode.VALIDATION, "Email already used");
        }
        ValidationResponse userValidation = userValidator.validate(user);
        user.setPassword(encryptor.encryptSHA256(user.getPassword()));
        if (userValidation.getIsValid()) {
                userRepository.save(user);
                return "Success";
        } else {
            throw new ServiceException(ServiceException.ErrorCode.VALIDATION, userValidation.getMessages().toString());
        }
    }
}
