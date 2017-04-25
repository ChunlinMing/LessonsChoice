package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改教师实体
 * Created by mingchunlin on 17/4/24.
 */
public class ChangeTeacher implements Serializable
{
    /**
     * 要更改的教师ID
     */
    private String teacherIdBefore;

    /**
     * 更改为此教师ID
     */
    private String teacherIdAfter;

    /**
     * 更改为此姓名
     */
    private String teacherNameAfter;

    /**
     * 更改为此性别
     */
    private String teacherGenderAfter;

    /**
     * 更改为此学院
     */
    private String teacherSchoolAfter;

    /**
     * 更改为此邮箱
     */
    private String teacherEmailAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getTeacherIdBefore()
    {
        return teacherIdBefore;
    }

    public void setTeacherIdBefore(String teacherIdBefore)
    {
        this.teacherIdBefore = teacherIdBefore;
    }

    public String getTeacherIdAfter()
    {
        return teacherIdAfter;
    }

    public void setTeacherIdAfter(String teacherIdAfter)
    {
        this.teacherIdAfter = teacherIdAfter;
    }

    public String getTeacherNameAfter()
    {
        return teacherNameAfter;
    }

    public void setTeacherNameAfter(String teacherNameAfter)
    {
        this.teacherNameAfter = teacherNameAfter;
    }

    public String getTeacherGenderAfter()
    {
        return teacherGenderAfter;
    }

    public void setTeacherGenderAfter(String teacherGenderAfter)
    {
        this.teacherGenderAfter = teacherGenderAfter;
    }

    public String getTeacherSchoolAfter()
    {
        return teacherSchoolAfter;
    }

    public void setTeacherSchoolAfter(String teacherSchoolAfter)
    {
        this.teacherSchoolAfter = teacherSchoolAfter;
    }

    public String getTeacherEmailAfter()
    {
        return teacherEmailAfter;
    }

    public void setTeacherEmailAfter(String teacherEmailAfter)
    {
        this.teacherEmailAfter = teacherEmailAfter;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }
}
