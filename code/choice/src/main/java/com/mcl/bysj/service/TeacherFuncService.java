package com.mcl.bysj.service;

import com.mcl.bysj.entity.LessonInfo;
import com.mcl.bysj.vo.UpdateLesson;

import java.util.List;

/**
 * 课程操作逻辑接口
 * Created by mingchunlin on 17/4/29.
 */
public interface TeacherFuncService
{
    List<LessonInfo> findLessonByTeacher(String teacherId);


    int insertLesson(LessonInfo lessonInfo);


    int updateLesson(UpdateLesson updateLesson);


    int deleteLesson(String lessonId);
}
