package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.controller.utils.HDInfo;
import com.jianda.smarthealth.dao.DoctorDao;
import com.jianda.smarthealth.dao.HospitalDao;
import com.jianda.smarthealth.pojo.Department;
import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Hospital;
import com.jianda.smarthealth.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalDao hospitalDao;
    @Autowired
    DoctorDao doctorDao;

    @Override
    public boolean newHospital(Hospital hospital) {
        return hospitalDao.addHospital(hospital)>0;
    }

    @Override
    public boolean changeHospitalInfo(Hospital hospital) {
        return hospitalDao.updateInfoById(hospital)>0;
    }

    @Override
    public List<Hospital> searchByCondition(Hospital hospital) {
        return hospitalDao.selectByCondition(hospital);
    }

    @Override
    public HDInfo[] getAllInfo() {
        List<Hospital> hospitals = hospitalDao.selectByCondition(null);
        HDInfo[] info = new HDInfo[hospitals.size()];
        int i = 0;
        int j = 0;
        for (Hospital hospital : hospitals){
            HDInfo hinfo = new HDInfo();
            hinfo.setValue(hospital.getId());
            hinfo.setLabel(hospital.getName());
            info[i] = hinfo;
            List<Department> departments = hospitalDao.selectDepartmentsByHospitalId(hospital.getId());
            HDInfo[] cinfo = new HDInfo[departments.size()];
            for (Department department : departments){
                HDInfo dinfo = new HDInfo();
                dinfo.setValue(department.getId());
                dinfo.setLabel(department.getName());
                cinfo[j] = dinfo;
                j++;
            }
            info[i].setChildren(cinfo);
            i++;
            j=0;
        }
        return info;
    }

    @Override
    public Hospital getOneHospital(int hospitalId) {
        return hospitalDao.selectByIdHospital(hospitalId);
    }

    @Override
    public boolean setDepartment(int hospitalId, int departmentId) {
        Map<String,Object> map = new HashMap<>();
        map.put("hospitalId", hospitalId);
        map.put("departmentId", departmentId);
        return hospitalDao.addDepartment4Hospital(map)>0;
    }

    @Override
    public boolean deprecateDepartment(int hospitalId, int departmentId) {
        Map<String,Object> map = new HashMap<>();
        map.put("hospitalId",hospitalId);
        map.put("departmentId",departmentId);
        doctorDao.setDepartmentId(hospitalId,departmentId,0);//受到影响的医生did设置为0
        return hospitalDao.deleteDepartment4Hospital(map)>0;
    }

    @Override
    public List<Department> getDepartments(int hospitalId) {
        return hospitalDao.selectDepartmentsByHospitalId(hospitalId);
    }

    @Override
    public List<Doctor> getDoctors(int hospitalId, int departmentId) {
        return hospitalDao.selectDocByHidDid(hospitalId,departmentId);
    }
}
