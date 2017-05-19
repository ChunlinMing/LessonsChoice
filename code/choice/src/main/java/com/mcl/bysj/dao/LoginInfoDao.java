package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LoginInfo;

/**
 * LoginInfo实体Dao接口类
 * Created by mingchunlin on 17/4/14.
 */
public interface LoginInfoDao
{
    /**
     * 查询用户类型
     * @param loginInfo 用户登录信息
     * @return Integer 用户类型编号
     */
    Integer findUserType(LoginInfo loginInfo);

    /**
     * 根据登录账户查找用户
     * @param loginInfo 登录信息
     * @return 查找结果
     */
    LoginInfo findUserById(LoginInfo loginInfo);

    /**
     * 注册用户
     * @return 成功1，失败0
     */
    int insertUser(LoginInfo loginInfo);

    /**
     * 更改用户密码
     * @param loginInfo 用户登录信息
     * @return 成功1，失败0
     */
    int updateUser(LoginInfo loginInfo);

    /**
     * 删除用户
     * @param userId 用户ID
     * @return 成功1，失败0
     */
    int deleteUser(String userId);
}
