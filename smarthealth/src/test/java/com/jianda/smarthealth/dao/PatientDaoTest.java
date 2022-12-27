package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.Registration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class PatientDaoTest {
    @Autowired
    PatientDao patientDao;

    @Test
    public void testSelectByCondition(){
        Patient patient = new Patient();
        //patient.setPhoneNum("7936");
        List<Patient> patients = patientDao.selectByCondition(patient);
        patients.forEach(System.out::println);
    }

    @Test
    public void testAddRegistrationInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("patientId",11);
        map.put("doctorId",3);
        patientDao.addRegistrationInfo(map);
    }

    @Test
    public void testSelectR(){
        List<Registration> registrations = patientDao.selectRegistration4Patient(0);
        registrations.forEach(System.out::println);
    }

    @Test
    public void testDelete(){
        patientDao.deleteRegistrationById(0);
    }
}
