package com.jianda.smarthealth.controller;

import com.jianda.smarthealth.controller.utils.HDInfo;
import com.jianda.smarthealth.controller.utils.Result;
import com.jianda.smarthealth.pojo.*;
import com.jianda.smarthealth.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    UserService userService;
    @Autowired
    PatientService patientService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    HealthArchiveService healthArchiveService;


    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User userR = userService.getOne(user.getUsername(),user.getPassword(),3);
        if (userR != null){
            return Result.success(userR,"登录成功");
        }
        else{
            return Result.error("登录失败");
        }

    }

    //密码更改
    //对Admin进行密码更改和User操作暂时一致
    @PutMapping("/changePwd")
    public Result changeAdminPwd(@RequestBody User user){
        if (userService.changePassword(22,user.getPassword())){
            return Result.success(null,"密码更新成功");
        }
        else{
            return Result.error("密码修改失败");
        }
    }

    //User管理(禁用，启用，密码更改，查询)
    //禁用
    @DeleteMapping("/user/{id}")
    public Result deleteUser(@PathVariable Integer id){
        if (userService.deprecateUser(id)){
            return Result.success(null,"用户已禁用");
        }
        else{
            return Result.error("禁用失败");
        }
    }

    //启用
    @PutMapping("/user/{id}")
    public Result activateUser(@PathVariable Integer id){
        if (userService.activateUser(id)){
            return Result.success(null,"用户已启用");
        }
        else{
            return Result.error("启用失败");
        }
    }

    //密码更改
    @PutMapping("/user/changePwd")
    public Result changedUserPwd(@RequestBody User user){
        if (userService.changePassword(user.getId(),user.getPassword())){
            return Result.success(null,"密码更新成功");
        }
        else{
            return Result.error("密码修改失败");
        }
    }

    //查询
    @GetMapping("/user")
    public Result getUser(User user){
        List<User> users = userService.searchByUsername(user.getUsername());
        if (users != null){
            return Result.success(users,"查询成功");
        }
        else{
            return Result.error("不存在该用户");
        }
    }

    //Patient管理(新建，更改，查询)
    //新建 先Patient再User
    @PostMapping("/patient")
    public Result savePatient(User user,Patient patient){
        if(patientService.newPatient(user,patient)){
            return Result.success(null,"注册成功");
        }
        else {
            return Result.error("注册失败");
        }
    }

    //更改
    @PutMapping("/patient")
    public Result updatePatient(@RequestBody Patient patient){
        System.out.println(patient);
        if (patientService.changePatientInfo(patient)){
            return Result.success(null,"更新成功");
        }
        else {
            return Result.error("更新失败");
        }
    }

    //查询一个
    @GetMapping("/patient/{id}")
    public Result getOnePatient(@PathVariable Integer id){
        Patient onePatient = patientService.getOnePatient(id);
        if(onePatient != null){
            return Result.success(onePatient,"查询成功");
        }
        else {
            return Result.error("同步失败");
        }
    }
    //查询
    @GetMapping("/patient")
    public Result getPatient(Patient patient){
        List<Patient> patients = patientService.searchByCondition(patient);
        if (patients != null){
            return Result.success(patients,"查询成功");
        }
        else{
            return Result.error("不存在该用户");
        }
    }

    //Doctor管理(新建,更改，查询)
    //新建 先doc再user
    @PostMapping("/doctor")
    public Result saveDoctor(User user,Doctor doctor){
        if(doctorService.newDoctor(user,doctor)){
            return Result.success(null,"注册成功");
        }
        else {
            return Result.error("注册失败");
        }
    }

    //更改
    @PutMapping("/doctor")
    public Result updateDoctor(@RequestBody Doctor doctor){
        if (doctorService.changeDoctorInfo(doctor)){
            return Result.success(null,"更新成功");
        }
        else {
            return Result.error("更新失败");
        }
    }

    //查询一个
    @GetMapping("/doctor/{id}")
    public Result getOneDoctor(@PathVariable Integer id){
        Doctor oneDoctor = doctorService.getOneDoctor(id);
        if(oneDoctor != null){
            return Result.success(oneDoctor,"查询成功");
        }
        else {
            return Result.error("同步失败");
        }
    }

    //查询
    @GetMapping("/doctor")
    public Result getDoctor(Doctor doctor){
        List<Doctor> doctors = doctorService.searchByCondition(doctor);
        if (doctors != null){
            return Result.success(doctors,"查询成功");
        }
        else{
            return Result.error("不存在该用户");
        }
    }

    //Hospital管理(新建，更改，查询  医院部门添加，弃用，查询)
    //新建
    @PostMapping("/hospital")
    public Result saveHospital(@RequestBody Hospital hospital){
        if(hospitalService.newHospital(hospital)){
            return Result.success(null,"添加成功");
        }
        else {
            return Result.error("添加失败");
        }
    }

    //更改
    @PutMapping("/hospital")
    public Result updateHospital(@RequestBody Hospital hospital){
        if (hospitalService.changeHospitalInfo(hospital)){
            return Result.success(null,"更新成功");
        }
        else {
            return Result.error("更新失败");
        }
    }

    //查询
    @GetMapping("/hospital")
    public Result getHospital(Hospital hospital){
        List<Hospital> hospitals = hospitalService.searchByCondition(hospital);
        if (hospitals != null){
            return Result.success(hospitals,"查询成功");
        }
        else{
            return Result.error("不存在该医院");
        }
    }

    //查询一个
    @GetMapping("/hospital/{id}")
    public Result getOneHospital(@PathVariable Integer id){
        Hospital oneHospital = hospitalService.getOneHospital(id);
        if(oneHospital != null){
            return Result.success(oneHospital,"查询成功");
        }
        else {
            return Result.error("同步失败");
        }
    }

    //全部医院+部门查询
    @GetMapping("/hospital/allInfo")
    public Result getHospitalDepartmentIDs(){
        HDInfo[] allInfo = hospitalService.getAllInfo();
        return Result.success(allInfo,"查询成功");
    }

    //医院部门添加
    @GetMapping("/hospital/addD/{hId}/{dId}")
    public Result saveDepartment4Hospital(@PathVariable int hId,@PathVariable int dId){
        if (hospitalService.setDepartment(hId,dId)){
            return Result.success(null,"添加成功");
        }
        else{
            return Result.error("添加失败");
        }
    }

    //弃用
        @DeleteMapping("/hospital/delD/{hId}/{dId}")
    public Result deleteDepartment4Hospital(@PathVariable int hId,@PathVariable int dId){
        if (hospitalService.deprecateDepartment(hId, dId)){
            return Result.success(null,"删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }

    //查询
    @GetMapping("/hospital/getD/{hId}")
    public Result getDepartment4Hospital(@PathVariable int hId){
        List<Department> departments = hospitalService.getDepartments(hId);
        if (departments != null){
            return Result.success(departments,"查询成功");
        }
        else{
            return Result.error("暂无部门");
        }
    }

    //Department管理(新建，更改，查询)
    //新建
    @PostMapping("/department")
    public Result saveDepartment(@RequestBody Department department){
        if(departmentService.newDepartment(department)){
            return Result.success(null,"添加成功");
        }
        else {
            return Result.error("添加失败");
        }
    }

    //更改
    @PutMapping("/department")
    public Result updateDepartment(@RequestBody Department department){
        if (departmentService.changeDepartmentInfo(department)){
            return Result.success(null,"更新成功");
        }
        else {
            return Result.error("更新失败");
        }
    }

    //查询
    @GetMapping("/department")
    public Result getDepartment(Department department){
        List<Department> departments = departmentService.searchByName(department.getName());
        if (departments != null){
            return Result.success(departments,"查询成功");
        }
        else{
            return Result.error("不存在该用户");
        }
    }

    //查询一个
    @GetMapping("/department/{id}")
    public Result getOneDepartment(@PathVariable Integer id){
        Department oneDepartment = departmentService.getOneDepartment(id);
        if(oneDepartment != null){
            return Result.success(oneDepartment,"查询成功");
        }
        else {
            return Result.error("同步失败");
        }
    }

    //HealthArchive管理(查询，禁用)
    //查询
    @GetMapping("/healthArchive")
    public Result getHA(HealthArchive healthArchive){
        List<HealthArchive> healthArchives = healthArchiveService.searchArchives(healthArchive.getPatientId(), healthArchive.getDoctorId());
        if (healthArchives != null){
            return Result.success(healthArchives,"查询成功");
        }
        else{
            return Result.error("暂无健康档案");
        }
    }

    //禁用
    @DeleteMapping("/healthArchive/{id}")
    public Result deleteHA(@PathVariable int id){
        if (healthArchiveService.deprecateArchive(id)){
            return Result.success(null,"禁用成功");
        }
        else{
            return Result.error("禁用失败");
        }
    }
    
}
