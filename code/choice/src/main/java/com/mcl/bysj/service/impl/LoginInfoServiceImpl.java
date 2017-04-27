package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.LoginInfoDao;
import com.mcl.bysj.dao.StuDao;
import com.mcl.bysj.dao.TeacherDao;
import com.mcl.bysj.entity.LoginInfo;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LoginInfo逻辑实现
 * Created by mingchunlin on 17/4/15.
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService
{
    @Autowired
    private LoginInfoDao loginInfoDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StuDao stuDao;

    /**
     * 查询用户类型
     * @param loginInfo 登录信息
     * @return 用户类型编号
     */
    public Integer findUserType(LoginInfo loginInfo)
    {
        return loginInfoDao.findUserType(loginInfo);
    }

    /**
     * 根据登录账户查找用户
     * @param loginInfo 登录信息
     * @return 存在学生且未注册2，存在教师且未注册1，已注册-100，不存在-200
     */
    public int findUserById(LoginInfo loginInfo)
    {
        if (null == loginInfoDao.findUserById(loginInfo))
        {
            Student student = new Student();
            Teacher teacher = new Teacher();
            student.setStuId(loginInfo.getUserId());
            teacher.setTeacherId(loginInfo.getUserId());
            if (null != stuDao.findStudent(student))
            {
                return 2;
            }
            if (null != teacherDao.findTeacher(teacher))
            {
                return 1;
            }
            return -200;
        }
        return -100;
    }

    /**
     * 注册用户
     * @return 成功1，失败0
     */
    public int insertUser(LoginInfo loginInfo)
    {
        return loginInfoDao.insertUser(loginInfo);
    }

    /**
     * 重置密码
     * @param loginInfo 用户登录信息
     * @return 成功1，失败0
     */
    public int updateUser(LoginInfo loginInfo)
    {
        return loginInfoDao.updateUser(loginInfo);
    }
}
