package org.gyu.develop.domain.common.jwt;

import lombok.RequiredArgsConstructor;
import org.gyu.develop.domain.user.dao.UserRepository;
import org.gyu.develop.domain.user.dto.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userRepository.findByEmail(name);

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
