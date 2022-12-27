package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    private int id;
    private String trueName;
    private String gender;
    private Date birthday;
    private String phoneNum;
    private String address;

    //年龄范围查询
    //private String queryRightDay;
    //private String queryLeftDay;
}
