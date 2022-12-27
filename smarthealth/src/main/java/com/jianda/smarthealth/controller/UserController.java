package com.jianda.smarthealth.controller;

import com.jianda.smarthealth.controller.utils.Result;
import com.jianda.smarthealth.pojo.User;
import com.jianda.smarthealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/enroll/{infoId}")
    public Result enrollUser(@PathVariable int infoId, @RequestBody User user){
        if (userService.usernameIsExist(user.getUsername())){
            return Result.error("该用户名已被注册");
        }else{
            user.setInfoId(infoId);
            if (userService.newUser(user)){
                return Result.success(user,"注册成功");
            }
            else{
                return Result.error("注册失败");
            }
        }

    }
}
