package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 邮件验证码实体类
 * Created by mingchunlin on 17/4/25.
 */
public class ValidationCode implements Serializable
{
    /**
     * 工号或学号
     */
    private String userId;

    /**
     * 验证码
     */
    private String validationCode;

    /**
     * 是否过期
     */
    private Boolean expireFlag;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getValidationCode()
    {
        return validationCode;
    }

    public void setValidationCode(String validationCode)
    {
        this.validationCode = validationCode;
    }

    public Boolean isExpireFlag()
    {
        return expireFlag;
    }

    public void setExpireFlag(Boolean expireFlag)
    {
        this.expireFlag = expireFlag;
    }
}
