package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改验证码使用状况实体类
 * Created by mingchunlin on 17/4/26.
 */
public class UpdateValidationCode implements Serializable
{
    /**
     * 工号或学号
     */
    private String userId;

    /**
     * 之前的是否过期标志
     */
    private Boolean expireFlagBefore;

    /**
     * 之后的是否过期标志
     */
    private Boolean expireFlagAfter;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Boolean getExpireFlagBefore()
    {
        return expireFlagBefore;
    }

    public void setExpireFlagBefore(Boolean expireFlagBefore)
    {
        this.expireFlagBefore = expireFlagBefore;
    }

    public Boolean getExpireFlagAfter() {
        return expireFlagAfter;
    }

    public void setExpireFlagAfter(Boolean expireFlagAfter)
    {
        this.expireFlagAfter = expireFlagAfter;
    }
}
