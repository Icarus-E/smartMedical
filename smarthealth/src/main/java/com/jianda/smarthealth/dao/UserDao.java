package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {
    int addUser(User user);//添加user，并将生成的主键id赋予user的id属性
    int deleteById(int id);//将user设置为禁用
    int reuseById(int id);//解除禁用
    int updatePassword(Map<String,Object> map);//更新密码
    User selectByUsername(String username);

    //int updateInfoId(Map<String,Object> map);//给user设置infoId（详细信息）
    List<User> selectAllUsers();//查询非禁用user
    List<User> selectUserByUsername(String username);//根据username查询

    User selectOne(@Param("username") String username, @Param("password") String password,@Param("status") int status);
}
