package com.mcl.bysj.dao;

/**
 * LoginInfo实体Dao接口类
 * Created by mingchunlin on 17/4/14.
 */
public interface LoginInfoDao {
    /**
     * 查询用户类型
     * @param userId 用户ID
     * @param userPwd 用户密码
     * @return Integer 用户类型编号
     */
    Integer findUserType(String userId,String userPwd);


}
