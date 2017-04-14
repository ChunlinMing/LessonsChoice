package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 班级信息实体类
 * Created by mingchunlin on 17/4/10.
 */
public class StuClass implements Serializable
{
    /**
     * 班级
     */
    private String stuClass;

    /**
     * 所在学院
     */
    private String school;

    public String getStuClass()
    {
        return stuClass;
    }

    public void setStuClass(String stuClass)
    {
        this.stuClass = stuClass;
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
