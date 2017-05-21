package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 选课信息实体类
 * Created by mingchunlin on 17/4/10.
 */
public class LessonChoice implements Serializable
{
    /**
     * 学号
     */
    private String stuId;

    /**
     * 课程编号
     */
    private String lessonId;

    /**
     * 课程名称
     */
    private String lessonName;

    /**
     * 课程类型
     */
    private String lessonType;

    /**
     * 课程学分
     */
    private Double lessonScore;

    /**
     * 上课时间
     */
    private String lessonTime;

    /**
     * 哪几周上课
     */
    private String lessonWeeks;

    /**
     * 上课学期
     */
    private Integer term;

    /**
     * 上课教室
     */
    private String classroom;

    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    public String getStuId()
    {
        return stuId;
    }

    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

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

    public String getLessonType()
    {
        return lessonType;
    }

    public void setLessonType(String lessonType)
    {
        this.lessonType = lessonType;
    }

    public Double getLessonScore()
    {
        return lessonScore;
    }

    public void setLessonScore(Double lessonScore)
    {
        this.lessonScore = lessonScore;
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

    public Integer getTerm()
    {
        return term;
    }

    public void setTerm(Integer term)
    {
        this.term = term;
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
}
