package com.greens.greengram.user;

import com.greens.greengram.ResVo;
import com.greens.greengram.user.model.UserProfileInfoVo;
import com.greens.greengram.user.model.UserInsDto;
import com.greens.greengram.user.model.UserSigninVo;
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
    public UserSigninVo login(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }
    // /api/user/2
    @GetMapping("/{targetIuser}")
    public UserProfileInfoVo getUserProfileInfo(@PathVariable int targetIuser){
        return service.getUserProfileInfo(targetIuser);
    }

}