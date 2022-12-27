package com.jianda.smarthealth.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthArchive {
    private int id;
    private int patientId;
    private int doctorId;
    private String illnessDescription;
    private String diagnoseDescription;
    private String treatmentDescription;
    private Date date;
    private String additionDescription;
}
