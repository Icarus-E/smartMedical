package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Doctor;
import com.jianda.smarthealth.pojo.Registration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DoctorDao {
    int addDoctor(Doctor doctor);//添加doctor，并将生成的主键id赋予doctor的id属性
    int updateInfoById(Doctor doctor);//更新doctor信息
    List<Doctor> selectByCondition(Doctor doctor);//条件模糊查询
    Doctor selectByIdDoctor(int doctorId);

    int setDepartmentId(@Param("hId") int hId,@Param("dOldId") int dOldId, @Param("dNewId") int dNewId);

    List<Registration> selectRegistration4Doctor(int doctorId);
    int deleteRegistration(int id);
}
