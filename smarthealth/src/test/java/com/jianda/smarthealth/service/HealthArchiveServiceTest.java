package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.HealthArchive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class HealthArchiveServiceTest {
    @Autowired
    HealthArchiveService healthArchiveService;

    @Test
    public void testNew(){
        HealthArchive healthArchive = new HealthArchive(0,6,1,"test","test","test",new Date(2022-1900,7-1,20),"test");
        healthArchiveService.newHealthArchive(healthArchive);
    }

    @Test
    public void testSearch(){
        healthArchiveService.searchArchives(0,0);
    }

    @Test
    public void testDeprecate(){
        healthArchiveService.deprecateArchive(1);
    }
}
