package com.mcl.bysj.service;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.vo.ChangeSchool;

import java.util.List;

/**
 * 管理学院名称逻辑接口
 * Created by mingchunlin on 17/4/21.
 */
public interface SchoolService
{
    List<School> findAllSchools();

    int insertSchool(School school);

    int updateSchool(ChangeSchool changeSchool);

    int deleteSchool(School school);
}
