package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.TeacherLessonDao;
import com.mcl.bysj.entity.LessonInfo;
import com.mcl.bysj.service.TeacherFuncService;
import com.mcl.bysj.vo.UpdateLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程操作逻辑实现
 * Created by mingchunlin on 17/4/29.
 */
@Service
public class TeacherFuncServiceImpl implements TeacherFuncService
{
    @Autowired
    TeacherLessonDao teacherLessonDao;

    /**
     * 根据教师id查找课程
     * @param teacherId 教师id
     * @return 课程集合
     */
    public List<LessonInfo> findLessonByTeacher(String teacherId)
    {
        return teacherLessonDao.findLessonByTeacher(teacherId);
    }

    /**
     * 添加课程
     * @param lessonInfo 课程对象
     * @return 成功1，失败0，已存在-100
     */
    public int insertLesson(LessonInfo lessonInfo)
    {
        if (null == teacherLessonDao.findLessonById(lessonInfo.getLessonId()))
        {
            return teacherLessonDao.insertLesson(lessonInfo);
        }
        return -100;
    }

    /**
     * 更改课程信息
     * @param updateLesson 更改课程对象
     * @return 成功1，失败0，已存在-100，不可更改-500
     */
    public int updateLesson(UpdateLesson updateLesson)
    {
        int choseStu = teacherLessonDao.findChoseStuByLesson(updateLesson.getLessonIdBefore());
        if (choseStu > 0)
        {
            return -500;
        }
        if (updateLesson.getLessonIdAfter().equals(updateLesson.getLessonIdBefore()))
        {
            LessonInfo lessonInfo = new LessonInfo();
            lessonInfo.setLessonId(updateLesson.getLessonIdAfter());
            lessonInfo.setLessonName(updateLesson.getLessonNameAfter());
            lessonInfo.setLessonOptionalStu(updateLesson.getLessonOptionalStuAfter());
            lessonInfo.setClassroom(updateLesson.getClassroomAfter());
            lessonInfo.setGradeYear(updateLesson.getGradeYearAfter());
            lessonInfo.setLessonScore(updateLesson.getLessonScoreAfter());
            lessonInfo.setLessonTime(updateLesson.getLessonTimeAfter());
            lessonInfo.setLessonType(updateLesson.getLessonTypeAfter());
            lessonInfo.setLessonWeeks(updateLesson.getLessonWeeksAfter());
            lessonInfo.setSchool(updateLesson.getSchoolAfter());
            lessonInfo.setTerm(updateLesson.getTermAfter());
            if (null == teacherLessonDao.findLessonByEntity(lessonInfo))
            {
                return teacherLessonDao.updateLesson(updateLesson);
            }
        }
        else
        {
            if (null == teacherLessonDao.findLessonById(updateLesson.getLessonIdBefore()))
            {
                return teacherLessonDao.updateLesson(updateLesson);
            }
        }
        return -100;
    }

    /**
     * 删除课程
     * @param lessonId 课程id
     * @return 成功1，失败0，不存在-200，不可删除-500
     */
    public int deleteLesson(String lessonId)
    {
        if (null != teacherLessonDao.findLessonById(lessonId))
        {
            int choseStu = teacherLessonDao.findChoseStuByLesson(lessonId);
            if (choseStu > 0)
            {
                return -500;
            }
            return teacherLessonDao.deleteLesson(lessonId);
        }
        return -200;
    }
}
