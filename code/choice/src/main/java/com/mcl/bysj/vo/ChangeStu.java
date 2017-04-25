package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改学生信息实体类
 * Created by mingchunlin on 17/4/24.
 */
public class ChangeStu implements Serializable
{
    /**
     * 要更改的学生的学号
     */
    private String stuIdBefore;

    /**
     * 更改为此学号
     */
    private String stuIdAfter;

    /**
     * 更改为此姓名
     */
    private String stuNameAfter;

    /**
     * 更改为此性别
     */
    private String stuGenderAfter;

    /**
     * 更改为此学院
     */
    private String stuSchoolAfter;

    /**
     * 更改为此班级
     */
    private String stuClassAfter;

    /**
     * 更改为此年级
     */
    private Integer gradeYearAfter;

    /**
     * 更改为此邮箱
     */
    private String stuEmailAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getStuIdBefore()
    {
        return stuIdBefore;
    }

    public void setStuIdBefore(String stuIdBefore)
    {
        this.stuIdBefore = stuIdBefore;
    }

    public String getStuIdAfter()
    {
        return stuIdAfter;
    }

    public void setStuIdAfter(String stuIdAfter)
    {
        this.stuIdAfter = stuIdAfter;
    }

    public String getStuNameAfter()
    {
        return stuNameAfter;
    }

    public void setStuNameAfter(String stuNameAfter)
    {
        this.stuNameAfter = stuNameAfter;
    }

    public String getStuGenderAfter()
    {
        return stuGenderAfter;
    }

    public void setStuGenderAfter(String stuGenderAfter)
    {
        this.stuGenderAfter = stuGenderAfter;
    }

    public String getStuSchoolAfter()
    {
        return stuSchoolAfter;
    }

    public void setStuSchoolAfter(String stuSchoolAfter)
    {
        this.stuSchoolAfter = stuSchoolAfter;
    }

    public String getStuClassAfter()
    {
        return stuClassAfter;
    }

    public void setStuClassAfter(String stuClassAfter)
    {
        this.stuClassAfter = stuClassAfter;
    }

    public Integer getGradeYearAfter()
    {
        return gradeYearAfter;
    }

    public void setGradeYearAfter(Integer gradeYearAfter)
    {
        this.gradeYearAfter = gradeYearAfter;
    }

    public String getStuEmailAfter()
    {
        return stuEmailAfter;
    }

    public void setStuEmailAfter(String stuEmailAfter)
    {
        this.stuEmailAfter = stuEmailAfter;
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
