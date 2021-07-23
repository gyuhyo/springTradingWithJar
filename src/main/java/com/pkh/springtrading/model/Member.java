package com.pkh.springtrading.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@ToString
public class Member {
    private String email;
    private String password;
    private String name;
    private String nick;
    private LocalDateTime regDate;
}
