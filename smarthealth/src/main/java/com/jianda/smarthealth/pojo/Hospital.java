package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    private int id;
    private String name;
    private String phoneNum;
    private String address;
    private int grade;
    private String website;
    private String description;
}
