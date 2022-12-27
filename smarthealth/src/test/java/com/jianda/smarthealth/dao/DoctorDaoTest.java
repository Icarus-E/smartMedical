package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Registration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoctorDaoTest {
    @Autowired
    DoctorDao doctorDao;
    @Test
    public void testUpdateInfoById(){
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setPost(2);
        doctor.setGender("female");
        doctorDao.updateInfoById(doctor);
    }
    @Test
    public void testSelectByCondition(){
        doctorDao.selectByCondition(new Doctor());
    }

    @Test
    public void testSetDepartment(){
        doctorDao.setDepartmentId(1,3,0);
    }

    @Test
    public void testSelectR(){
        List<Registration> registrations = doctorDao.selectRegistration4Doctor(1);
        registrations.forEach(System.out::println);
    }

    @Test
    public void testFinish(){
        doctorDao.deleteRegistration(3);
    }
}
