package com.jianda.smarthealth.controller;

import com.jianda.smarthealth.controller.utils.Result;
import com.jianda.smarthealth.pojo.*;
import com.jianda.smarthealth.service.DoctorService;
import com.jianda.smarthealth.service.HealthArchiveService;
import com.jianda.smarthealth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    UserService userService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    HealthArchiveService healthArchiveService;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User userR = userService.getOne(user.getUsername(),user.getPassword(),2);
        if (userR != null){
            return Result.success(userR,"登录成功");
        }
        else{
            return Result.error("登录失败");
        }
    }

    //注册
    @PostMapping("/enroll")
    public Result enrollDoc(@RequestBody Doctor doctor){
        int infoId = doctorService.setDoctor(doctor);
        if(infoId >0){
            return Result.success(infoId,"注册成功");
        }
        else {
            return Result.error("注册失败");
        }
    }

    //查询挂号信息
    @GetMapping("/{id}")
    public Result getRegistration(@PathVariable int id){
        List<Registration> registrations = doctorService.searchRegistrations(id);
        if (!registrations.isEmpty()){
            return Result.success(registrations,"查询成功");
        }
        else{
            return Result.error("暂无挂号信息");
        }
    }

    //诊断(生成HA，删除挂号信息)
    @PostMapping("/diagnose/{RId}")
    public Result diagnose(@PathVariable int RId,@RequestBody HealthArchive healthArchive){
        healthArchiveService.newHealthArchive(healthArchive);
        if (doctorService.finishRegistration(RId)){
            return Result.success(null,"诊断成功");
        }
        else{
            return Result.error("患者已取消挂号");
        }
    }

    //看病历
    @GetMapping("/HA/{pId}")
    public Result getHA4Patient(@PathVariable int pId){
        List<HealthArchive> healthArchives = healthArchiveService.searchArchives(pId, 0);
        if (!healthArchives.isEmpty()){
            return Result.success(healthArchives,"查询成功");
        }
        else{
            return Result.error("该患者没有健康档案");
        }
    }

    //我的历史诊断
    @GetMapping("/HA/doc/{docId}")
    public Result getHA4Doctor(@PathVariable int docId){
        List<HealthArchive> healthArchives = healthArchiveService.searchArchives(0, docId);
        if (!healthArchives.isEmpty()){
            return Result.success(healthArchives,"查询成功");
        }
        else{
            return Result.error("您还没有历史诊断");
        }
    }

}
