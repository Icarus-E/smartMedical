package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentDaoTest {
    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void testDepartmentDao(){
        departmentDao.selectByName("");
    }
}
