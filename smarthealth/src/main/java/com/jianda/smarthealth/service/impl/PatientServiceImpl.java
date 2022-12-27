package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.dao.PatientDao;
import com.jianda.smarthealth.dao.UserDao;
import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.Registration;
import com.jianda.smarthealth.pojo.User;
import com.jianda.smarthealth.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    UserDao userDao;
    @Autowired
    PatientDao patientDao;

    @Override
    public boolean newPatient(User user, Patient patient) {

        user.setStatus(1);
        int uNum = userDao.addUser(user);
        int userId = user.getId();
        int pNum = patientDao.addPatient(patient);
        int infoId = patient.getId();

        Map<String, Object> map = new HashMap<>();
        map.put("id",userId);
        map.put("infoId",infoId);
        int upNum = 1;
        return uNum>0&&pNum>0&&upNum>0;
    }

    @Override
    public int setPatient(Patient patient) {
        patientDao.addPatient(patient);
        return patient.getId();
    }

    @Override
    public boolean changePatientInfo(Patient patient) {
        System.out.println(patient);
        return patientDao.updateInfoById(patient)>0;
    }

    @Override
    public List<Patient> searchByCondition(Patient patient) {
        return patientDao.selectByCondition(patient);
    }

    @Override
    public Patient getOnePatient(int patientId) {
        return patientDao.selectByIdPatient(patientId);
    }


    @Override
    public boolean setRegistration(int patientId, int doctorId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("patientId", patientId);
        map.put("doctorId", doctorId);
        return patientDao.addRegistrationInfo(map)>0;
    }

    @Override
    public List<Registration> searchRegistration4Patient(int patientId) {
        return patientDao.selectRegistration4Patient(patientId);
    }

    @Override
    public boolean cancelRegistration(int registrationId) {
        return patientDao.deleteRegistrationById(registrationId)>0;
    }
}
