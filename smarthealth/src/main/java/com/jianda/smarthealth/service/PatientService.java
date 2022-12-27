package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.Registration;
import com.jianda.smarthealth.pojo.User;

import java.util.List;

public interface PatientService {
    boolean newPatient(User user, Patient patient);//创建user patient并通过info_id联系起来
    int setPatient(Patient patient);//创建Patient并返回id
    boolean changePatientInfo(Patient patient);//更新患者信息，此处传入带id的患者对象
    List<Patient> searchByCondition(Patient patient);
    Patient getOnePatient(int patientId);

    boolean setRegistration(int patientId, int doctorId);
    List<Registration> searchRegistration4Patient(int patientId);
    boolean cancelRegistration(int registrationId);
}
