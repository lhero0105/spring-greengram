package com.greens.greengram.user.model;

import lombok.Data;

@Data
public class UserSigninProcVo {
    // DB에서 가져온 데이터를 담을 친구 //Proc 프로세서 > 처리 뜻
    private int iuser;
    private String upw;
    private String nm;
    private String pic;
}
