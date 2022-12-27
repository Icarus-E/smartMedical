package com.jianda.smarthealth.dao;

import com.jianda.smarthealth.pojo.HealthArchive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface HealthArchiveDao {
    int addHealthArchive(HealthArchive healthArchive);
    int deleteById(int id);
    List<HealthArchive> selectByIds(Map<String,Object> map);
}
