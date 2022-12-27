package com.jianda.smarthealth.service.impl;

import com.jianda.smarthealth.dao.HealthArchiveDao;
import com.jianda.smarthealth.pojo.HealthArchive;
import com.jianda.smarthealth.service.HealthArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HealthArchiveServiceImpl implements HealthArchiveService {
    @Autowired
    HealthArchiveDao healthArchiveDao;

    @Override
    public boolean newHealthArchive(HealthArchive healthArchive) {
        return healthArchiveDao.addHealthArchive(healthArchive)>0;
    }

    @Override
    public List<HealthArchive> searchArchives(int patientId, int doctorId) {
        Map<String,Object> map = new HashMap<>();
        map.put("patientId", patientId);
        map.put("doctorId", doctorId);
        List<HealthArchive> healthArchives = healthArchiveDao.selectByIds(map);
        healthArchives.forEach(System.out::println);
        return healthArchives;
    }

    @Override
    public boolean deprecateArchive(int id) {
        return healthArchiveDao.deleteById(id)>0;
    }
}
