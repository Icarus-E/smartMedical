package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testDeprecate(){
        userService.deprecateUser(13);
    }

    @Test
    public void testActivate(){
        userService.activateUser(13);
    }
    @Test
    public void testSearch(){
        userService.searchByUsername("");
    }
    @Test
    public void testChangePwd(){
        User user = new User();
        user.setId(13);
        //userService.changePassword(user,"changed");
    }
}
