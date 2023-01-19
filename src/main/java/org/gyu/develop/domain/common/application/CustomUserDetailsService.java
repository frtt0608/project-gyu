package org.gyu.develop.domain.common.application;

import lombok.RequiredArgsConstructor;
import org.gyu.develop.domain.member.dao.MemberRepository;
import org.gyu.develop.domain.member.dto.Member;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return memberRepository.findByName(name)
                .map(this::settingUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 userPk 입니다."));
    }

    private UserDetails settingUserDetails(Member member) {
        return User.builder()
                .username(member.getName())
                .password(passwordEncoder.encode(member.getPassword()))
                .authorities(member.getAuthorities())
                .build();
    }
}
