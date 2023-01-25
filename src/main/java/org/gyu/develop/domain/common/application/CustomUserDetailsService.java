package org.gyu.develop.domain.common.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gyu.develop.domain.member.dao.MemberRepository;
import org.gyu.develop.domain.member.dto.Member;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email)
                .map(this::settingUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 userPk 입니다."));
    }

    private UserDetails settingUserDetails(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        // 왜 안됐지?
//        UserDetails user = User.builder()
//                .username(member.getEmail())
//                .password(passwordEncoder.encode(member.getPassword()))
//                .build();

        return member;
    }
}
