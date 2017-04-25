package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改学院名称实体类
 * Created by mingchunlin on 17/4/21.
 */
public class ChangeSchool implements Serializable
{
    /**
     * 要更改的学院名称
     */
    private String schoolBefore;

    /**
     * 更改为此学院名称
     */
    private String schoolAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getSchoolBefore()
    {
        return schoolBefore;
    }

    public void setSchoolBefore(String schoolBefore)
    {
        this.schoolBefore = schoolBefore;
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
