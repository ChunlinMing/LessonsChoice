package com.mcl.bysj.entity;

/**
 * 登录实体类
 * Created by mingchunlin on 17/4/10.
 */
public class LoginInfo
{
    /**
     * 用户登录ID
     */
    private String userId;

    /**
     * 用户登录密码
     */
    private String userPwd;

    /**
     * 用户类型
     */
    private int userType;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserPwd()
    {
        return userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }
}
