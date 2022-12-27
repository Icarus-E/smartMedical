package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.dao.DepartmentDao;
import com.jianda.smarthealth.pojo.Department;
import com.jianda.smarthealth.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    @Override
    public boolean newDepartment(Department department) {
        return departmentDao.addDepartment(department)>0;
    }

    @Override
    public boolean changeDepartmentInfo(Department department) {
        return departmentDao.updateInfoById(department)>0;
    }

    @Override
    public List<Department> searchByName(String name) {
        return departmentDao.selectByName(name);
    }

    @Override
    public Department getOneDepartment(int departmentId) {
        return departmentDao.selectByIdDepartment(departmentId);
    }
}
