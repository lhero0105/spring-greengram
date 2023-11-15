package com.greens.greengram.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSigninVo { // JSON으로 응답 용으로 사용
    private int result; // 로그인 성공(1), 아이디 없음(2), 비밀번호 다름(3)
    private int iuser;
    private String nm;
    private String pic;
}
