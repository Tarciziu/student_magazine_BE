package main.controller;

import com.google.protobuf.ServiceException;
import main.controller.request.UserDTO;
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

    @PostMapping("/login")
    ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok().body(userService.login(userDTO.getEmail(), userDTO.getPassword()));
        } catch (Exception e) { // TODO replace with ServiceException
            return ResponseEntity.status(500).body(e.getMessage()); // TODO replace with ValidationMessage
        }
    }
}
