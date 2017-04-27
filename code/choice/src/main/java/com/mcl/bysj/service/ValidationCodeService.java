package com.mcl.bysj.service;

import com.mcl.bysj.entity.ValidationCode;
import com.mcl.bysj.vo.UpdateValidationCode;

import java.util.List;

/**
 * 邮件验证码相关逻辑接口
 * Created by mingchunlin on 17/4/26.
 */
public interface ValidationCodeService
{
    String findEmail(String userId);

    List<ValidationCode> findUnExpiredCode(ValidationCode validationCode);

    ValidationCode findValidationCode(ValidationCode validationCode);

    int insertValidationCode(ValidationCode validationCode);

    int updateValidationCode(UpdateValidationCode updateValidationCode);
}
