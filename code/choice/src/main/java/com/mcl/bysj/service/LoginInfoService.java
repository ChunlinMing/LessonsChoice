package com.mcl.bysj.service;

import com.mcl.bysj.entity.LoginInfo;

/**
 * LoginInfo逻辑接口
 * Created by mingchunlin on 17/4/15.
 */
public interface LoginInfoService
{
    Integer findUserType(LoginInfo loginInfo);
}
