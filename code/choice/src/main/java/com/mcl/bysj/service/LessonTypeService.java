package com.mcl.bysj.service;

import com.mcl.bysj.entity.LessonType;
import com.mcl.bysj.vo.ChangeLessonType;

import java.util.List;

/**
 * 课程类型操作逻辑接口
 * Created by mingchunlin on 17/4/21.
 */
public interface LessonTypeService
{
    int insertLessonType(LessonType lessonType);

    List<LessonType> findAllLessonTypes();

    int updateLessonType(ChangeLessonType changeLessonType);

    int deleteLessonType(LessonType lessonType);
}
