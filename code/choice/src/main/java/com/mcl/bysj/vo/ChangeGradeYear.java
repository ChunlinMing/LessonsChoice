package com.mcl.bysj.vo;

/**
 * 更改年级实体类
 * Created by mingchunlin on 17/4/21.
 */
public class ChangeGradeYear
{
    /**
     * 要更改的学期
     */
    private Integer gradeYearBefore;

    /**
     * 更改为此学期
     */
    private Integer gradeYearAfter;

    public Integer getGradeYearBefore()
    {
        return gradeYearBefore;
    }

    public void setGradeYearBefore(Integer gradeYearBefore)
    {
        this.gradeYearBefore = gradeYearBefore;
    }

    public Integer getGradeYearAfter()
    {
        return gradeYearAfter;
    }

    public void setGradeYearAfter(Integer gradeYearAfter)
    {
        this.gradeYearAfter = gradeYearAfter;
    }
}
