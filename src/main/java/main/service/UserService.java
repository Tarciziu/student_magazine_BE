package main.service;

import main.domain.Student;
import main.domain.User;
import main.exception.ServiceException;
import main.repository.AdministratorRepository;
import main.repository.StudentRepository;
import main.repository.UserRepository;
import main.validator.UserValidator;
import main.validator.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final AdministratorRepository administratorRepository;
    private final UserValidator userValidator;
    Encryptor encryptor;

    @Autowired
    UserService(UserRepository userRepository, UserValidator userValidator,
                StudentRepository studentRepository, AdministratorRepository administratorRepository,
                Encryptor encryptor){
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.administratorRepository = administratorRepository;
        this.userValidator = userValidator;
        this.encryptor = encryptor;
    }

    @Override
    public String login(String email, String password) throws ServiceException {
        Optional<User> user = userRepository.findById(email);

        if (user.isEmpty()) {
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "Email or password incorrect");
        }

        if (!BCrypt.checkpw(password, user.get().getPassword())) {
            throw new ServiceException(ServiceException.ErrorCode.INTERNAL, "Email or password incorrect");
        }

        if (studentRepository.findByUser(user.get()).isPresent()){
            return "Student";
        }

        if (administratorRepository.findByUser(user.get()).isPresent()){
            return "Administrator";
        }

        return "User";
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
