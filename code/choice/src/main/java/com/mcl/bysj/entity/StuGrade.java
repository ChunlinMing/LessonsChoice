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
     * 学生姓名
     */
    private String stuName;

    /**
     * 学生所在班级
     */
    private String stuClass;

    /**
     * 上课学期
     */
    private Integer term;

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
    private Double stuGrade;

    public String getStuId()
    {
        return stuId;
    }

    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

    public Integer getTerm()
    {
        return term;
    }

    public void setTerm(Integer term)
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

    public Double getStuGrade()
    {
        return stuGrade;
    }

    public void setStuGrade(Double stuGrade)
    {
        this.stuGrade = stuGrade;
    }

    public String getStuName()
    {
        return stuName;
    }

    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuClass()
    {
        return stuClass;
    }

    public void setStuClass(String stuClass)
    {
        this.stuClass = stuClass;
    }
}
