package com.greens.greengram.user;

import com.greens.greengram.ResVo;
import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;
    @PostMapping
    // 나중에 네이밍을 signUp으로 해줍니다.
    public ResVo postUser(@RequestBody UserInsDto dto){
        System.out.println(dto);
        int result = service.postUser(dto);
        return new ResVo(result);

    }
    @PostMapping("/signin")
    public ResVo login(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }

}