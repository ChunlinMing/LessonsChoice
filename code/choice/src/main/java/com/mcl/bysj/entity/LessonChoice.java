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
    private double lessonScore;

    /**
     * 上课时间
     */
    private String lessonTime;

    /**
     * 哪几周上课
     */
    private String lessonWeeks;

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

    public double getLessonScore()
    {
        return lessonScore;
    }

    public void setLessonScore(double lessonScore)
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
}
