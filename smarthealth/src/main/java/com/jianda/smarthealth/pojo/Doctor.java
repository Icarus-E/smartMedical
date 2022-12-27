package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    Doctor {
    private int id;
    private String trueName;
    private String gender;
    private Date birthday;
    private String phoneNum;
    private int hospitalId;
    private int post;
    private int departmentId;
}
