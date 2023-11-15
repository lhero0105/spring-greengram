package com.greens.greengram.user;

import com.greens.greengram.ResVo;
import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninProcVo;
import com.greens.greengram.user.model.UserSigninVo;
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
    public UserSigninVo signin(UserSigninDto dto) {
        UserSigninVo vo = new UserSigninVo();
        vo.setResult(3);

        UserSigninProcVo procVo = mapper.selUserByUid(dto.getUid());
        if (procVo == null) {
            vo.setResult(2);
        } else if (procVo.getUpw().equals(dto.getUpw())) {
            vo.setResult(1);
            vo.setIuser(procVo.getIuser());
            vo.setNm(procVo.getNm());
            vo.setPic(procVo.getPic());
        }
        return vo;
    }
}