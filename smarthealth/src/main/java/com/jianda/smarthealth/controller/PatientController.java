package com.jianda.smarthealth.controller;

import com.jianda.smarthealth.controller.utils.Result;
import com.jianda.smarthealth.pojo.*;
import com.jianda.smarthealth.service.HealthArchiveService;
import com.jianda.smarthealth.service.HospitalService;
import com.jianda.smarthealth.service.PatientService;
import com.jianda.smarthealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    UserService userService;
    @Autowired
    PatientService patientService;
    @Autowired
    HospitalService hospitalService;
    @Autowired
    HealthArchiveService healthArchiveService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User userR = userService.getOne(user.getUsername(),user.getPassword(),1);
        if (userR != null){
            return Result.success(userR,"登录成功");
        }
        else{
            return Result.error("登录失败");
        }
    }

    //注册
    @PostMapping("/enroll")
    public Result enrollPatient(@RequestBody Patient patient){
        int infoId = patientService.setPatient(patient);
        System.out.println("infoId="+infoId);
        if(infoId >0){
            return Result.success(infoId,"注册成功");
        }
        else {
            return Result.error("注册失败");
        }
    }
    //查询医院
    @GetMapping("/hospital")
    public Result getHospital(Hospital hospital){
        List<Hospital> hospitals = hospitalService.searchByCondition(hospital);
        if (!hospitals.isEmpty()){
            return Result.success(hospitals,"查询成功");
        }
        else{
            return Result.error("不存在该医院");
        }
    }
    //查询医院部门
    @GetMapping("/hospital/{hId}")
    public Result getDepartment4Hospital(@PathVariable int hId){
        List<Department> departments = hospitalService.getDepartments(hId);
        if (!departments.isEmpty()){
            return Result.success(departments,"查询成功");
        }
        else{
            return Result.error("暂无部门");
        }
    }

    //查询部门下的医生
    @GetMapping("/hospital/{hId}/{dId}")
    public Result getDoctor4Department(@PathVariable int hId,@PathVariable int dId){
        List<Doctor> doctors = hospitalService.getDoctors(hId, dId);
        if (!doctors.isEmpty()){
            return Result.success(doctors,"查询成功");
        }
        else{
            return Result.error("该部门暂无医生");
        }
    }

    //新建挂号(医院=>科室=>医生)
    @GetMapping("/register/{pId}/{docId}")
    public Result saveRegistration(@PathVariable int pId,@PathVariable int docId){
        if (patientService.setRegistration(pId,docId)){
            return Result.success(null,"挂号成功");
        }
        else {
            return Result.error("挂号失败");
        }
    }

    //查询挂号
    @GetMapping("/register/{pId}")
    public Result getRegistration(@PathVariable int pId){
        List<Registration> registrations = patientService.searchRegistration4Patient(pId);
        System.out.println(registrations);
        if (!registrations.isEmpty()){
            return Result.success(registrations,"查询成功");
        }
        else{
            return Result.error("您还没有挂号");
        }
    }

    //取消挂号
    @DeleteMapping("/register/{rId}")
    public Result deleteRegistration(@PathVariable int rId){
        if (patientService.cancelRegistration(rId)){
            return Result.success(null,"取消成功");
        }
        else {
            return Result.error("取消失败");
        }
    }
    //查看HA
    @GetMapping("/HA/{pId}")
    public Result getHA(@PathVariable int pId){
        List<HealthArchive> healthArchives = healthArchiveService.searchArchives(pId, 0);
        healthArchives.forEach(System.out::println);
        if (!healthArchives.isEmpty()){
            return Result.success(healthArchives,"查询成功");
        }
        else{
            return Result.error("您还没有健康档案");
        }
    }

}
