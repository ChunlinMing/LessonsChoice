package com.mcl.bysj.entity;

/**
 * 教师实体类
 * Created by mingchunlin on 17/4/10.
 */
public class Teacher
{
    /**
     * 教师工号
     */
    private String teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 教师性别
     */
    private String teacherGender;

    /**
     * 教师所属学院
     */
    private String teacherSchool;

    /**
     * 教师邮箱
     */
    private String teacherEmail;

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

    public String getTeacherGender()
    {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender)
    {
        this.teacherGender = teacherGender;
    }

    public String getTeacherSchool()
    {
        return teacherSchool;
    }

    public void setTeacherSchool(String teacherSchool)
    {
        this.teacherSchool = teacherSchool;
    }

    public String getTeacherEmail()
    {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail)
    {
        this.teacherEmail = teacherEmail;
    }
}
