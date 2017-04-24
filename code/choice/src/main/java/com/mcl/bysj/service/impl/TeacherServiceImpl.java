package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.TeacherDao;
import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.service.TeacherService;
import com.mcl.bysj.vo.ChangeTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教师操作逻辑实现
 * Created by mingchunlin on 17/4/24.
 */
@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    TeacherDao teacherDao;

    /**
     * 根据id查找教师
     * @param teacher 教师对象
     * @return 查找结果
     */
    public Teacher findTeacher(Teacher teacher)
    {
        return teacherDao.findTeacher(teacher);
    }

    /**
     * 根据学院查找教师
     * @param school 学院
     * @return 查找到的教师集合
     */
    public List<Teacher> findAllTeacherBySchool(School school)
    {
        return teacherDao.findAllTeacherBySchool(school);
    }

    /**
     * 添加教师
     * @param teacher 教师
     * @return 成功1，失败0，已存在-100
     */
    public int insertTeacher(Teacher teacher)
    {
        if (null == teacherDao.findTeacher(teacher))
        {
            return teacherDao.insertTeacher(teacher);
        }
        return -100;
    }

    /**
     * 更改教师信息
     * @param changeTeacher 更改教师信息对象
     * @return 成功1，失败0，已存在-100
     */
    public int updateTeacher(ChangeTeacher changeTeacher)
    {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(changeTeacher.getTeacherIdAfter());
        if (changeTeacher.getTeacherIdAfter().equals(changeTeacher.getTeacherIdBefore()))
        {
            teacher.setTeacherName(changeTeacher.getTeacherNameAfter());
            teacher.setTeacherGender(changeTeacher.getTeacherGenderAfter());
            teacher.setTeacherSchool(changeTeacher.getTeacherSchoolAfter());
            teacher.setTeacherEmail(changeTeacher.getTeacherEmailAfter());
            if (null == teacherDao.findTeacherByEntity(teacher))
            {
                return teacherDao.updateTeacher(changeTeacher);
            }
        }
        else
        {
            if (null == teacherDao.findTeacher(teacher))
            {
                return teacherDao.updateTeacher(changeTeacher);
            }
        }
        return -100;
    }

    /**
     * 删除教师
     * @param teacher 教师
     * @return 成功1，失败0，不存在-200
     */
    public int deleteTeacher(Teacher teacher)
    {
        if (null != teacherDao.findTeacher(teacher))
        {
            return teacherDao.deleteTeacher(teacher);
        }
        return -200;
    }
}
