package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.LoginInfoDao;
import com.mcl.bysj.entity.LoginInfo;
import com.mcl.bysj.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginInfo逻辑实现
 * Created by mingchunlin on 17/4/15.
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService{
    @Autowired
    private LoginInfoDao loginInfoDao;

    /**
     * 查询用户类型
     * @param loginInfo 登录信息
     * @return 用户类型编号
     */
    public Integer findUserType(LoginInfo loginInfo)
    {
        return loginInfoDao.findUserType(loginInfo);
    }
}
