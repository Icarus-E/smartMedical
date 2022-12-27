package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.Registration;
import com.jianda.smarthealth.pojo.User;

import java.util.List;

public interface DoctorService {
    boolean newDoctor(User user, Doctor doctor);//创建user doctor并通过info_id联系起来
    int setDoctor(Doctor doctor);//创建Doc对象并返回id
    boolean changeDoctorInfo(Doctor doctor);//更新doc信息，此处传入带id的doc对象
    List<Doctor> searchByCondition(Doctor doctor);
    Doctor getOneDoctor(int doctorId);

    List<Registration> searchRegistrations(int doctorId);
    boolean finishRegistration(int RId);
}
