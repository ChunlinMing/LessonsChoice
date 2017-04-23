package com.mcl.bysj.service;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.vo.ChangeClass;

import java.util.List;

/**
 * 教学班操作逻辑接口
 * Created by mingchunlin on 17/4/23.
 */
public interface StuClassService
{
    StuClass findClass(StuClass stuClass);

    List<StuClass> findAllClassBySchool(School school);

    int insertClass(StuClass stuClass);

    int updateClass(ChangeClass changeClass);

    int deleteClass(StuClass stuClass);
}
