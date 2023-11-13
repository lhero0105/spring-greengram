package com.greens.greengram.user;

import com.greens.greengram.ResVo;
import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// final은 바로 값을 넣어주지 않으면 에러
// final이 있는 애들만 생성자로 넣어줍니다.
public class UserService {
    private final UserMapper mapper;
    public int postUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }
    //1: 아이디/비번 맞췄음 2: 아이디 없음 3 : 비밀번호 다름
    public ResVo signin(UserSigninDto dto){
        int result = 3;

        String savedUpw = mapper.selUserByUid(dto.getUid());
        System.out.println("savedIpw : " + savedUpw);
        if(savedUpw == null){
            result = 2;
        } else if (savedUpw.equals(dto.getUpw())){
            result = 1;
        }
        return new ResVo(result);
    }
}