package com.jianda.smarthealth.service;

import com.jianda.smarthealth.controller.utils.HDInfo;
import com.jianda.smarthealth.pojo.Department;
import com.jianda.smarthealth.pojo.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HospitalServiceTest {
    @Autowired
    HospitalService hospitalService;

    @Test
    public void testNewHospital(){
        Hospital hospital = new Hospital(0,"testName","testPnum","testAddr",9,"testWeb","testDesc");
        System.out.println(hospitalService.newHospital(hospital));
    }

    @Test
    public void testChange(){
        Hospital hospital = new Hospital();
        hospital.setId(2);
        hospital.setName("changed");
        hospitalService.changeHospitalInfo(hospital);
    }

    @Test
    public void testSearch(){
        List<Hospital> hospitals = hospitalService.searchByCondition(new Hospital());
        hospitals.forEach(System.out::println);
    }

    @Test
    public void testSetDepartment(){
        Hospital hospital = new Hospital();
        hospital.setId(1);
        Department department = new Department();
        department.setId(3);
        //hospitalService.setDepartment(hospital,department);
    }

    @Test
    public void testGetDepartments(){
        Hospital hospital = new Hospital();
        hospital.setId(1);
        //List<Department> departments = hospitalService.getDepartments(hospital);
        //departments.forEach(System.out::println);
    }

    @Test
    public void testDeprecate(){
        Hospital hospital = new Hospital();
        hospital.setId(1);
        Department department = new Department();
        department.setId(3);
        //hospitalService.deprecateDepartment(, hospital, ,department);
    }

    @Test
    public void testGetAllInfo(){
        HDInfo[] allInfo = hospitalService.getAllInfo();
        System.out.println(allInfo);
    }
}
