package org.gyu.develop.domain.common.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gyu.develop.domain.common.application.LoginService;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.gyu.develop.domain.common.dto.TokenInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody RequestLogin requestLogin) {
        log.info(" >>>>> LOGIN Controller");
        return loginService.login(requestLogin);
    }
}
