package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.User;

import java.util.List;

public interface UserService {
    boolean newUser(User user);
    boolean deprecateUser(int userId);
    boolean activateUser(int userId);
    boolean usernameIsExist(String username);

    User getOne(String username,String password,int status);
    boolean changePassword(int userId,String newPassword);
    List<User> searchByUsername(String username);
}
