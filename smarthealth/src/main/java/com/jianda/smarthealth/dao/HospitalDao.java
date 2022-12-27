package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Department;
import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Hospital;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HospitalDao {
    int addHospital(Hospital hospital);
    int updateInfoById(Hospital hospital);
    List<Hospital> selectByCondition(Hospital hospital);
    Hospital selectByIdHospital(int id);

    int addDepartment4Hospital(Map<String,Object> map);//给医院设置部门
    int deleteDepartment4Hospital(Map<String,Object> map);//给医院删除部门
    List<Department> selectDepartmentsByHospitalId(int hId);//搜索医院全部部门
    List<Doctor> selectDocByHidDid(@Param("hId") int hId,@Param("dId") int dId);
}
