package org.gyu.develop.domain.common.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gyu.develop.domain.common.application.LoginService;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.gyu.develop.domain.common.dto.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@NoArgsConstructor
@RestController
@RequestMapping("/member")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody RequestLogin requestLogin) {
        log.info(" >>>>> LOGIN Controller");
        return loginService.login(requestLogin);
    }
}
