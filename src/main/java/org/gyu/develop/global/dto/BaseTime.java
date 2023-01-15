package org.gyu.develop.global.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseTime {

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
}
