package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 学生实体类
 * Created by mingchunlin on 17/4/10.
 */
public class Student implements Serializable
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
     * 学生性别
     */
    private String stuGender;

    /**
     * 学生所在学院
     */
    private String stuSchool;

    /**
     * 学生班级
     */
    private String stuClass;

    /**
     * 学生年级
     */
    private int gradeYear;

    /**
     * 学生邮箱
     */
    private String stuEmail;

    public String getStuId()
    {
        return stuId;
    }

    public void setStuId(String stuId)
    {
        this.stuId = stuId;
    }

    public String getStuName()
    {
        return stuName;
    }

    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public String getStuGender()
    {
        return stuGender;
    }

    public void setStuGender(String stuGender)
    {
        this.stuGender = stuGender;
    }

    public String getStuSchool()
    {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool)
    {
        this.stuSchool = stuSchool;
    }

    public String getStuClass()
    {
        return stuClass;
    }

    public void setStuClass(String stuClass)
    {
        this.stuClass = stuClass;
    }

    public int getGradeYear()
    {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear)
    {
        this.gradeYear = gradeYear;
    }

    public String getStuEmail()
    {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail)
    {
        this.stuEmail = stuEmail;
    }
}
