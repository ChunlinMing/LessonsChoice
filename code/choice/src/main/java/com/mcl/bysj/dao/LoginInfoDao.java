package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LoginInfo;

/**
 * LoginInfo实体Dao接口类
 * Created by mingchunlin on 17/4/14.
 */
public interface LoginInfoDao {
    /**
     * 查询用户类型
     * @param loginInfo 用户登录信息
     * @return Integer 用户类型编号
     */
    Integer findUserType(LoginInfo loginInfo);


}
