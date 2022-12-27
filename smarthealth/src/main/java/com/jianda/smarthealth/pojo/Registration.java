package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private int id;
    private int remainNum;//剩余人数
    private int sumNum;//挂号总人数
    private int patientId;//查询操作需要用
    private int doctorId;//查询操作需要用

    //医生基本信息
    private String doctorName;
    private String doctorGender;
    private String departmentName;
    private int doctorPost;

    //患者基本信息
    private String patientName;
    private String patientGender;
    private String patientPhoneNum;

    private Date date;//挂号日期
}
