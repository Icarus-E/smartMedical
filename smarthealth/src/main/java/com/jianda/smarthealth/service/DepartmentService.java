package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.Department;

import java.util.List;

public interface DepartmentService {
    boolean newDepartment(Department department);
    boolean changeDepartmentInfo(Department department);
    List<Department> searchByName(String name);
    Department getOneDepartment(int departmentId);
}
