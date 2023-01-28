package org.gyu.develop.domain.common.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gyu.develop.domain.common.dto.RequestLogin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class LoginControllerTest {

    @Autowired
    private WebApplicationContext context;

    private RequestLogin requestLogin;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @BeforeEach
    public void setMockMvc() {

        String email = "frtt0608@naver.com";
        String password = "new1234!";
        requestLogin = new RequestLogin(email, password);

        //        this.mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    void login_테스트() throws Exception {

        mockMvc.perform(post("/member/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestLogin)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}