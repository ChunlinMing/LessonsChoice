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
    private Integer term;

    public Integer getTerm()
    {
        return term;
    }

    public void setTerm(Integer term)
    {
        this.term = term;
    }
}
