package main.controller;

import main.controller.request.UserDTO;
import main.domain.User;
import main.exception.ServiceException;
import main.service.IUserService;
import main.validator.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(userService.login(userDTO.getEmail(), userDTO.getPassword()));
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(userService.register(user));
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }
}
