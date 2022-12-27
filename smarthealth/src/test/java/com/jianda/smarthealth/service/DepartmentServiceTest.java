package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    public void testNew(){
        Department department = new Department(0,"test","test");
        departmentService.newDepartment(department);
    }

    @Test
    public void testChange(){
        Department department = new Department();
        department.setId(3);
        department.setDescription("changed");
        departmentService.changeDepartmentInfo(department);
    }

    @Test
    public void testSearch(){
        List<Department> departments = departmentService.searchByName("");
        departments.forEach(System.out::println);
    }
}
