package org.gyu.develop.domain.common.dto;

import lombok.Data;

@Data
public class RequestLogin {
    private String email;
    private String password;
}
