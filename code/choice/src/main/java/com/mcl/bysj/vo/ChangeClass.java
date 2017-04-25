package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改教学班实体类
 * Created by mingchunlin on 17/4/23.
 */
public class ChangeClass implements Serializable
{
    /**
     * 要更改的教学班号
     */
    private String stuClassBefore;

    /**
     * 更改为此教学班号
     */
    private String stuClassAfter;

    /**
     * 更改为此学院名
     */
    private String schoolAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getStuClassBefore()
    {
        return stuClassBefore;
    }

    public void setStuClassBefore(String stuClassBefore)
    {
        this.stuClassBefore = stuClassBefore;
    }

    public String getStuClassAfter()
    {
        return stuClassAfter;
    }

    public void setStuClassAfter(String stuClassAfter)
    {
        this.stuClassAfter = stuClassAfter;
    }

    public String getSchoolAfter()
    {
        return schoolAfter;
    }

    public void setSchoolAfter(String schoolAfter)
    {
        this.schoolAfter = schoolAfter;
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
