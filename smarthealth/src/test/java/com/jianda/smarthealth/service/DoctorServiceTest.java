package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class DoctorServiceTest {
    @Autowired
    DoctorService doctorService;
    @Test
    public void testNewDoctor(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        Doctor doctor = new Doctor();
        doctor.setTrueName("test");
        doctor.setGender("male");
        doctor.setBirthday(new Date(1988-1900,7-1,9));
        doctor.setPhoneNum("15012347894");
        doctor.setHospitalId(1);
        doctor.setPost(1);
        doctor.setDepartmentId(3);
        doctorService.newDoctor(user,doctor);
    }

    @Test
    public void testSearch(){
        doctorService.searchByCondition(new Doctor());
    }

    @Test
    public void testChange(){
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setTrueName("Siri1");
        doctorService.changeDoctorInfo(doctor);
    }
}
