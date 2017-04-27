package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.StuDao;
import com.mcl.bysj.dao.TeacherDao;
import com.mcl.bysj.dao.ValidationCodeDao;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.entity.ValidationCode;
import com.mcl.bysj.service.ValidationCodeService;
import com.mcl.bysj.vo.UpdateValidationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 邮件验证码相关逻辑实现
 * Created by mingchunlin on 17/4/26.
 */
@Service
public class ValidationCodeServiceImpl implements ValidationCodeService
{
    @Autowired
    private ValidationCodeDao validationCodeDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StuDao stuDao;

    /**
     * 查询邮箱信息
     * @param userId 登录id
     * @return 查找结果
     */
    public String findEmail(String userId)
    {
        Student student = new Student();
        student.setStuId(userId);
        Student stu = stuDao.findStudent(student);
        if (null != stu)
        {
            return stu.getStuEmail();
        }
        else
        {
            Teacher teacher = new Teacher();
            teacher.setTeacherId(userId);
            Teacher tea = teacherDao.findTeacher(teacher);
            if (null != tea)
            {
                return tea.getTeacherEmail();
            }
            return "1432608191@qq.com";
        }
    }

    /**
     * 查询邮件验证码
     * @param validationCode 邮件验证码
     * @return 查询结果
     */
    public ValidationCode findValidationCode(ValidationCode validationCode)
    {
        return validationCodeDao.findValidationCode(validationCode);
    }

    /**
     * 查询未某个用户未过期的验证码信息
     * @param validationCode 对象
     * @return 查找结果
     */
    public List<ValidationCode> findUnExpiredCode(ValidationCode validationCode)
    {
        return validationCodeDao.findUnExpiredCode(validationCode);
    }

    /**
     * 新增邮件验证码
     * @param validationCode 邮件验证码对象
     * @return 成功1，失败0
     */
    public int insertValidationCode(ValidationCode validationCode)
    {
        return validationCodeDao.insertValidationCode(validationCode);
    }

    /**
     * 更新邮件验证码使用状态
     * @param validationCode 邮件验证码对象
     * @return 成功1，失败0
     */
    public int updateValidationCode(UpdateValidationCode updateValidationCode)
    {
        return validationCodeDao.updateValidationCode(updateValidationCode);
    }
}
