package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LessonChoice;
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
     * 根据上课学期查询选修课程
     * @param lessonInfo 上课学期和选修类型
     * @return 选修课集合
     */
    List<LessonInfo> findOptionalLesson(LessonInfo lessonInfo);

    /**
     * 根据上课学期、年级和学院查找课程
     * @param lessonInfo 上课学期、年级和学院
     * @return 课程集合
     */
    List<LessonInfo> findRequiredLesson(LessonInfo lessonInfo);

    /**
     * 根据课程号查找选课信息
     * @param lessonId 课程号
     * @return 选课集合
     */
    List<LessonChoice> findAllLessonChoiceById(String lessonId);

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

    /**
     * 根据课程ID删除已选可课程
     * @param lessonId 课程ID
     * @return 成功1，失败0
     */
    int deleteLessonChoice(String lessonId);
}
