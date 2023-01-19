//package org.gyu.develop.domain.common.jwt;
//
//import lombok.RequiredArgsConstructor;
//import org.gyu.develop.domain.member.dao.MemberRepository;
//import org.gyu.develop.domain.member.dto.Member;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationProvider implements AuthenticationProvider {
//
//    private MemberRepository memberRepository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String name = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        Member user = memberRepository.findByName(name)
//                .orElseThrow(NullPointerException::new);
//
//        if(user.isMatchPassword(password)) {
//            throw new RuntimeException("패스워드가 틀렸습니다.");
//        }
//
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.)
//
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
