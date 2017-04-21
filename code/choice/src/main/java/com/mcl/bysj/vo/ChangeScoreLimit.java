package com.mcl.bysj.vo;

/**
 * 更改选课学分上限实体类
 * Created by mingchunlin on 17/4/21.
 */
public class ChangeScoreLimit
{
    /**
     * 原选课学分上限
     */
    private Double scoreLimitBefore;

    /**
     * 改为此学分上限
     */
    private Double scoreLimitAfter;

    public Double getScoreLimitBefore()
    {
        return scoreLimitBefore;
    }

    public void setScoreLimitBefore(Double scoreLimitBefore)
    {
        this.scoreLimitBefore = scoreLimitBefore;
    }

    public Double getScoreLimitAfter()
    {
        return scoreLimitAfter;
    }

    public void setScoreLimitAfter(Double scoreLimitAfter)
    {
        this.scoreLimitAfter = scoreLimitAfter;
    }
}
