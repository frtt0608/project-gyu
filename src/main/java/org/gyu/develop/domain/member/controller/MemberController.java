package org.gyu.develop.domain.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class MemberController {

    @GetMapping
    public String hello() {
        return "Hello world";
    }

    @PostMapping
    public void loginUser(@RequestBody RequestUser user, HttpServletRequest req) {

    }
}
