package com.jianda.smarthealth.service;

import com.jianda.smarthealth.controller.utils.HDInfo;
import com.jianda.smarthealth.pojo.Department;
import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Hospital;

import java.util.List;

public interface HospitalService {
    boolean newHospital(Hospital hospital);
    boolean changeHospitalInfo(Hospital hospital);
    List<Hospital> searchByCondition(Hospital hospital);
    HDInfo[] getAllInfo();
    Hospital getOneHospital(int hospitalId);

    boolean setDepartment(int hospitalId, int departmentId);
    boolean deprecateDepartment(int hospitalId, int departmentId);//删除医院部门，医生所处的部门需要跟着变动
    List<Department> getDepartments(int hospitalId);

    List<Doctor> getDoctors(int hospitalId,int departmentId);
}
