package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 课程信息实体类
 * Created by mingchunlin on 17/4/10.
 */
public class LessonInfo implements Serializable
{
    /**
     * 课程ID
     */
    private String lessonId;

    /**
     * 课程名
     */
    private String lessonName;

    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 上课的教室
     */
    private String classroom;

    /**
     * 上课的时间
     */
    private String lessonTime;

    /**
     * 在哪几周上课
     */
    private String lessonWeeks;

    /**
     * 本课程可选人数
     */
    private Integer lessonOptionalStu;

    /**
     * 当前选择人数
     */
    private Integer lessonChosedStu;

    /**
     * 课程类型
     */
    private String lessonType;

    /**
     * 上课学期
     */
    private Integer term;

    /**
     * 课程学分
     */
    private Double lessonScore;

    /**
     * 可选课的学生年级
     */
    private Integer gradeYear;

    /**
     * 可选课的学生学院
     */
    private String school;

    public String getLessonId()
    {
        return lessonId;
    }

    public void setLessonId(String lessonId)
    {
        this.lessonId = lessonId;
    }

    public String getLessonName()
    {
        return lessonName;
    }

    public void setLessonName(String lessonName)
    {
        this.lessonName = lessonName;
    }

    public String getTeacherId()
    {
        return teacherId;
    }

    public void setTeacherId(String teacherId)
    {
        this.teacherId = teacherId;
    }

    public String getTeacherName()
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }

    public String getClassroom()
    {
        return classroom;
    }

    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    public String getLessonTime()
    {
        return lessonTime;
    }

    public void setLessonTime(String lessonTime)
    {
        this.lessonTime = lessonTime;
    }

    public String getLessonWeeks()
    {
        return lessonWeeks;
    }

    public void setLessonWeeks(String lessonWeeks)
    {
        this.lessonWeeks = lessonWeeks;
    }

    public Integer getLessonOptionalStu()
    {
        return lessonOptionalStu;
    }

    public void setLessonOptionalStu(Integer lessonOptionalStu)
    {
        this.lessonOptionalStu = lessonOptionalStu;
    }

    public Integer getLessonChosedStu()
    {
        return lessonChosedStu;
    }

    public void setLessonChosedStu(Integer lessonChosedStu)
    {
        this.lessonChosedStu = lessonChosedStu;
    }

    public String getLessonType()
    {
        return lessonType;
    }

    public void setLessonType(String lessonType)
    {
        this.lessonType = lessonType;
    }

    public Integer getTerm()
    {
        return term;
    }

    public void setTerm(Integer term)
    {
        this.term = term;
    }

    public Double getLessonScore()
    {
        return lessonScore;
    }

    public void setLessonScore(Double lessonScore)
    {
        this.lessonScore = lessonScore;
    }

    public Integer getGradeYear()
    {
        return gradeYear;
    }

    public void setGradeYear(Integer gradeYear)
    {
        this.gradeYear = gradeYear;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }
}
