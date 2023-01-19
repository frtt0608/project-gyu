package org.gyu.develop.domain.common.application;

import lombok.RequiredArgsConstructor;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.gyu.develop.domain.common.dto.TokenInfo;
import org.gyu.develop.domain.common.jwt.TokenProvider;
import org.gyu.develop.domain.member.dao.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public TokenInfo login(RequestLogin requestLogin) {
        return tokenProvider.createToken(
                authenticationManagerBuilder.getObject().authenticate(
                                new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword())), requestLogin);
    }
}
