package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 学期实体类
 * Created by mingchunlin on 17/4/10.
 */
public class Term implements Serializable
{
    /**
     * 学期
     */
    private int term;

    public int getTerm()
    {
        return term;
    }

    public void setTerm(int term)
    {
        this.term = term;
    }
}
