package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 选课学分上限实体类
 * Created by mingchunlin on 17/4/10.
 */
public class ScoreLimit implements Serializable
{
    /**
     * 选课的学分上限
     */
    private double scoreLimit;

    public double getScoreLimit()
    {
        return scoreLimit;
    }

    public void setScoreLimit(double scoreLimit)
    {
        this.scoreLimit = scoreLimit;
    }
}
