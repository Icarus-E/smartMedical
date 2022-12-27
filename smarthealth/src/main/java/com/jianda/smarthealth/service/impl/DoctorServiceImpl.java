package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.dao.DoctorDao;
import com.jianda.smarthealth.dao.UserDao;
import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Registration;
import com.jianda.smarthealth.pojo.User;
import com.jianda.smarthealth.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    UserDao userDao;
    @Autowired
    DoctorDao doctorDao;

    @Override
    public boolean newDoctor(User user, Doctor doctor) {
        user.setStatus(2);
        int uNum = userDao.addUser(user);
        int userId = user.getId();
        int dNum = doctorDao.addDoctor(doctor);
        int infoId = doctor.getId();

        Map<String, Object> map = new HashMap<>();
        map.put("id",userId);
        map.put("infoId",infoId);
        int upNum = 1;
        return uNum>0&&dNum>0&&upNum>0;
    }

    @Override
    public int setDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
        return doctor.getId();
    }

    @Override
    public boolean changeDoctorInfo(Doctor doctor) {
        return doctorDao.updateInfoById(doctor)>0;
    }

    @Override
    public List<Doctor> searchByCondition(Doctor doctor) {
        return doctorDao.selectByCondition(doctor);
    }

    @Override
    public Doctor getOneDoctor(int doctorId) {
        return doctorDao.selectByIdDoctor(doctorId);
    }

    @Override
    public List<Registration> searchRegistrations(int doctorId) {
        return doctorDao.selectRegistration4Doctor(doctorId);
    }

    @Override
    public boolean finishRegistration(int RId) {
        return doctorDao.deleteRegistration(RId)>0;
    }
}
