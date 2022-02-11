package main.controller;

import main.controller.request.UserDTO;
import main.controller.response.UserRoleDTO;
import main.domain.User;
import main.exception.ServiceException;
import main.mapper.Mapper;
import main.service.IUserService;
import main.validator.ValidationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/welcome")
    String hello() {
        return "Hello";
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(new UserRoleDTO(userDTO.getEmail(),
                    userService.login(userDTO.getEmail(), userDTO.getPassword())));
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

    @PostMapping("/getByEmail")
    public ResponseEntity getByEmail(@RequestBody String email) {
        try{
            return ResponseEntity.ok().body(mapper.convertToUserProfileDTO(userService.getByEmail(email)));
        } catch (ServiceException e) {
            return ResponseEntity.status(500).body(new ValidationMessage(e.getMessage()));
        }
    }
}
