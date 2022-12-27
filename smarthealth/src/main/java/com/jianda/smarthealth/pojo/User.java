package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private int status;//1:patient 2:doctor 0:deprecate
    private int infoId;
}
