package org.gyu.develop.domain.member.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.gyu.develop.domain.common.dto.CustomUserDetails;
import org.gyu.develop.global.dto.BaseTime;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity(name="user")
public class Member extends CustomUserDetails {

    @Id
    @GeneratedValue()
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    public boolean isMatchPassword(String password) {
        return this.password.equals(password);
    }
}
