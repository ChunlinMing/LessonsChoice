package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 学院实体类
 * Created by mingchunlin on 17/4/10.
 */
public class School implements Serializable
{
    /**
     * 学院名称
     */
    private String school;

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }
}
