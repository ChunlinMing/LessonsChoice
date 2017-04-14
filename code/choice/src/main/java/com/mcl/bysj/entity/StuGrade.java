package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 学生成绩实体类
 * Created by mingchunlin on 17/4/10.
 */
public class StuGrade implements Serializable
{
    /**
     * 学号
     */
    private String stuId;

    /**
     * 上课学期
     */
    private int term;

    /**
     * 课程类型
     */
    private String lessonType;

    /**
     * 课程编号
     */
    private String lessonId;

    /**
     * 课程名称
     */
    private String lessonName;

    /**
     * 考试类型
     */
    private String examType;

    /**
     * 学生成绩
     */
    private double stuGrade;

    public String getStuId()
    {
        return stuId;
    }

    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

    public int getTerm()
    {
        return term;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }

    public String getLessonType()
    {
        return lessonType;
    }

    public void setLessonType(String lessonType)
    {
        this.lessonType = lessonType;
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

    public String getExamType()
    {
        return examType;
    }

    public void setExamType(String examType)
    {
        this.examType = examType;
    }

    public double getStuGrade()
    {
        return stuGrade;
    }

    public void setStuGrade(double stuGrade)
    {
        this.stuGrade = stuGrade;
    }
}
