package org.gyu.develop.domain.common.controller;

import lombok.RequiredArgsConstructor;
import org.gyu.develop.domain.common.application.LoginService;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.gyu.develop.domain.common.dto.TokenInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public TokenInfo login(@RequestBody RequestLogin requestLogin) {
        return loginService.login(requestLogin);
    }
}
