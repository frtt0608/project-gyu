package org.gyu.develop.domain.common.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.gyu.develop.domain.common.dto.TokenInfo;
import org.gyu.develop.domain.common.jwt.TokenProvider;
import org.gyu.develop.domain.member.dao.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public TokenInfo login(RequestLogin requestLogin) {
        log.info(requestLogin.toString());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(requestLogin.getEmail(), requestLogin.getPassword());

        // authenticate 메서드를 통해 CustomUserService > loadUserByUsername 메서드 실행 > 인증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 인증 정보 기반으로 JWT 생성
        TokenInfo tokenInfo = tokenProvider.createToken(authentication, requestLogin);

        return tokenInfo;
    }
}
