package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void userDaoTest(){
        User user = new User();
        user.setUsername("patient4");
        user.setPassword("123456");

        System.out.println(userDao.addUser(user));
        System.out.println(user.getId());
        List<User> users = userDao.selectAllUsers();
        users.forEach(System.out::println);
        //Map<String, Object> map = new HashMap<>();
        //map.put("password","changed");
        //map.put("id",2);
        //userDao.updatePassword(map);
        //List<User> users2 = userDao.selectAllUsers();
        //users2.forEach(System.out::println);
        //System.out.println(userDao.selectUserByUsername("patient1"));
    }

    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }

    @Test
    public void testGetOne(){
        System.out.println(userDao.selectOne("admin","123456",3));
    }
}
