package main.controller;

import main.domain.User;
import main.exception.ServiceException;
import main.service.IUserService;
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

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(userService.register(user));
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
