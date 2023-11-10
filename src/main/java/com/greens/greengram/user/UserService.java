package com.greens.greengram.user;

import com.greens.greengram.ResVo;
import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    public int postUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }
    //1: 아이디/비번 맞췄음 2: 아이디 없음 3 : 비밀번호 다름
    public ResVo signin(UserSigninDto dto){
        int result = 3;

        String savedIpw = mapper.selUserByUid(dto.getUid());
        System.out.println("savedIpw : " + savedIpw);
        if(savedIpw == null){
            result = 2;
        } else if (savedIpw.equals(dto.getIpw())){
            result = 1;
        }
        return new ResVo(result);
    }
}
