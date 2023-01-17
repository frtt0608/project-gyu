package org.gyu.develop.domain.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.gyu.develop.domain.user.dto.RequestUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @PostMapping
    public void loginUser(@RequestBody RequestUser user, HttpServletRequest req) {

    }
}
