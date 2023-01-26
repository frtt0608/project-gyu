package org.gyu.develop.domain.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestLogin {
    private String email;
    private String password;
}
