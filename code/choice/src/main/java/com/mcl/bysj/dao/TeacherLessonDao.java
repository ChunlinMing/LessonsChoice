package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LessonInfo;
import com.mcl.bysj.vo.UpdateLesson;

import java.util.List;

/**
 * 教师管理课程dao接口
 * Created by mingchunlin on 17/4/28.
 */
public interface TeacherLessonDao
{
    /**
     * 根据课程id查找课程信息
     * @param lessonId 课程id
     * @return 查找结果
     */
    LessonInfo findLessonById(String lessonId);

    /**
     * 根据课程对象查找课程信息
     * @param lessonInfo 课程对象
     * @return 查找结果
     */
    LessonInfo findLessonByEntity(LessonInfo lessonInfo);

    /**
     * 根据教师id查找课程
     * @param teacherId 教师id
     * @return 课程集合
     */
    List<LessonInfo> findLessonByTeacher(String teacherId);

    /**
     * 根据课程id查找已选课人数
     * @param lessonId 课程id
     * @return 人数
     */
    Integer findChoseStuByLesson(String lessonId);

    /**
     * 根据课程id查找可选人数
     * @param lessonId 课程id
     * @return 人数
     */
    Integer findOptionalStuByLesson(String lessonId);

    /**
     * 添加课程
     * @param lessonInfo 课程对象
     * @return 成功1，失败0
     */
    int insertLesson(LessonInfo lessonInfo);

    /**
     * 更改课程信息
     * @param updateLesson 更改课程对象
     * @return 成功1，失败0
     */
    int updateLesson(UpdateLesson updateLesson);

    /**
     * 删除课程
     * @param lessonId 课程id
     * @return 成功1，失败0
     */
    int deleteLesson(String lessonId);
}
