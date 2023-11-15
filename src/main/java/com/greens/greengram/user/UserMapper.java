package com.greens.greengram.user;

import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninProcVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto udto);
    UserSigninProcVo selUserByUid(String uid); // 레코드가 없다면 무조건 null 리턴
}