package com.jianda.smarthealth.service;

import com.jianda.smarthealth.pojo.HealthArchive;

import java.util.List;

public interface HealthArchiveService {
    boolean newHealthArchive(HealthArchive healthArchive);
    List<HealthArchive> searchArchives(int patientId, int doctorId);
    boolean deprecateArchive(int id);
}
