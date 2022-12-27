package com.jianda.smarthealth.service;

import com.jianda.smarthealth.dao.PatientDao;
import com.jianda.smarthealth.dao.UserDao;
import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    PatientService  patientService;

    @Test
    public void newPatientTest(){
        User user = new User();
        user.setUsername("test4R3");
        user.setPassword("123456");
        Patient patient = new Patient();
        patient.setTrueName("test4R3");
        patient.setGender("female");
        patient.setBirthday(new Date(2022-1900,7-1,9));
        patient.setPhoneNum("15812341234");
        patient.setAddress("ADDRESS...");
        patientService.newPatient(user,patient);
    }

    @Test
    public void testSearch(){
        patientService.searchByCondition(new Patient());
    }

    @Test
    public void testSetR(){
        Patient patient = new Patient();
        patient.setId(6);
        Doctor doctor = new Doctor();
        doctor.setId(1);
        //patientService.setRegistration(patient,doctor);
    }

    @Test
    public void searchR(){
        Patient patient = new Patient();
        patient.setId(10);
        patientService.searchRegistration4Patient(8);
    }

/*
    @Test
    public void testGetR(){
        patientService.cancelRegistration();
    }
*/
}
