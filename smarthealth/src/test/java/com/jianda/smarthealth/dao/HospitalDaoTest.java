package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class HospitalDaoTest {
    @Autowired
    HospitalDao hospitalDao;

    @Test
    public void addHospitalTest(){
        Hospital hospital = new Hospital();
        hospital.setName("The First Hospital of Jilin University");
        hospital.setPhoneNum("0431-88782291");
        hospital.setAddress("No.71 Xinmin Street, Chaoyang District, Changchun City, Jilin Province");
        hospital.setGrade(10);
        hospital.setWebsite("https://jdyy.cn");
        hospital.setDescription("...");
        hospitalDao.addHospital(hospital);
    }

    @Test
    public void updateHospitalTest(){
        Hospital hospital = new Hospital();
        hospital.setId(1);
        hospital.setDescription("changed");
        hospitalDao.updateInfoById(hospital);
    }

    @Test
    public void selectHospitalTest(){
        hospitalDao.selectByCondition(new Hospital());
    }

    @Test
    public void testAddDepartment4Hospital(){
        Map<String,Object> map = new HashMap<>();
        map.put("hospitalId",1);
        map.put("departmentId",1);
        hospitalDao.addDepartment4Hospital(map);
    }
}
