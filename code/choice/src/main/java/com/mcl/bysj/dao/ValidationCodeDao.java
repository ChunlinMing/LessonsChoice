package com.mcl.bysj.dao;

import com.mcl.bysj.entity.ValidationCode;
import com.mcl.bysj.vo.UpdateValidationCode;

import java.util.List;

/**
 * 验证码相关
 * Created by mingchunlin on 17/4/26.
 */
public interface ValidationCodeDao
{
    /**
     * 查询邮件验证码
     * @param validationCode 邮件验证码
     * @return 查询结果
     */
    ValidationCode findValidationCode(ValidationCode validationCode);

    /**
     * 查询未某个用户未过期的验证码信息
     * @param validationCode 对象
     * @return 查找结果
     */
    List<ValidationCode> findUnExpiredCode(ValidationCode validationCode);

    /**
     * 新增邮件验证码
     * @param validationCode 邮件验证码对象
     * @return 成功1，失败0
     */
    int insertValidationCode(ValidationCode validationCode);

    /**
     * 更新邮件验证码使用状态
     * @param validationCode 邮件验证码对象
     * @return 成功1，失败0
     */
    int updateValidationCode(UpdateValidationCode updateValidationCode);
}
