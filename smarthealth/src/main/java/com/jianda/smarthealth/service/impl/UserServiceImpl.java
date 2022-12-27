package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.dao.UserDao;
import com.jianda.smarthealth.pojo.User;
import com.jianda.smarthealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean newUser(User user) {
        return userDao.addUser(user)>0;
    }

    @Override
    public boolean deprecateUser(int userId) {
        return userDao.deleteById(userId)>0;
    }

    @Override
    public boolean activateUser(int userId) {
        return userDao.reuseById(userId)>0;
    }

    @Override
    public boolean usernameIsExist(String username) {
        return userDao.selectByUsername(username) != null;
    }

    @Override
    public User getOne(String username, String password, int status) {
        return userDao.selectOne(username,password,status);
    }

    @Override
    public boolean changePassword(int userId, String newPassword) {
        Map<String,Object> map = new HashMap<>();
        map.put("password",newPassword);
        map.put("id", userId);
        return userDao.updatePassword(map)>0;
    }

    @Override
    public List<User> searchByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
}
