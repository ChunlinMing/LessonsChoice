package com.mcl.bysj.vo;

/**
 * 更改学期的实体类
 * Created by mingchunlin on 17/4/20.
 */
public class ChangeTerm
{
    /**
     * 要更改的学期
     */
    private Integer termBefore;

    /**
     * 更改为此学期
     */
    private Integer termAfter;

    public Integer getTermBefore()
    {
        return termBefore;
    }

    public void setTermBefore(Integer termBefore)
    {
        this.termBefore = termBefore;
    }

    public Integer getTermAfter()
    {
        return termAfter;
    }

    public void setTermAfter(Integer termAfter)
    {
        this.termAfter = termAfter;
    }
}
