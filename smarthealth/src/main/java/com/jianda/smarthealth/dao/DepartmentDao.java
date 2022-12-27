package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentDao {
    int addDepartment(Department department);
    int updateInfoById(Department department);
    List<Department> selectByName(String name);
    Department selectByIdDepartment(int departmentId);
}
