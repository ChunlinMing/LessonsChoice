package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 学生年级实体类
 * Created by mingchunlin on 17/4/10.
 */
public class GradeYear implements Serializable
{
    /**
     * 学生年级
     */
    private Integer gradeYear;

    public Integer getGradeYear()
    {
        return gradeYear;
    }

    public void setGradeYear(Integer gradeYear)
    {
        this.gradeYear = gradeYear;
    }
}
