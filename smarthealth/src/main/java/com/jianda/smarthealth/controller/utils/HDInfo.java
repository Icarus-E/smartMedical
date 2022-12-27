package com.jianda.smarthealth.controller.utils;

import lombok.Data;

@Data
public class HDInfo {
    private Integer value;
    private String label;
    private HDInfo[] children;
}
