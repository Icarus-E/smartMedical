package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Patient;
import com.jianda.smarthealth.pojo.Registration;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PatientDao {
    int addPatient(Patient patient);//添加patient，并将生成的主键id赋予patient的id属性
    int updateInfoById(Patient patient);//更新patient信息
    List<Patient> selectByCondition(Patient patient);//条件模糊查询
    Patient selectByIdPatient(int patientId);

    int addRegistrationInfo(Map<String,Object> map);//添加挂号信息
    List<Registration> selectRegistration4Patient(int patientId);//查询挂号信息
    int deleteRegistrationById(int id);//删除挂号信息
}
