package com.mcl.bysj.dao;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.vo.ChangeTeacher;

import java.util.List;

/**
 * 教师实体dao接口
 * Created by mingchunlin on 17/4/24.
 */
public interface TeacherDao
{
    /**
     * 根据教师工号查找教师
     * @param teacher 包含教师工号的对象
     * @return 查找结果
     */
    Teacher findTeacher(Teacher teacher);

    /**
     * 根据教师对象查找教师
     * @param teacher 教师对象
     * @return 查找结果
     */
    Teacher findTeacherByEntity(Teacher teacher);

    /**
     * 根据学院查找教师
     * @param school 学院
     * @return 查找到的教师集合
     */
    List<Teacher> findAllTeacherBySchool(School school);

    /**
     * 查询所有教师
     * @return 教师集合
     */
    List<Teacher> findAllTeacher();

    /**
     * 添加教师
     * @param teacher 教师
     * @return 成功1，失败0
     */
    int insertTeacher(Teacher teacher);

    /**
     * 更改教师信息
     * @param changeTeacher 更改教师信息对象
     * @return 成功1，失败0
     */
    int updateTeacher(ChangeTeacher changeTeacher);

    /**
     * 更改教师邮箱
     * @param teacher 教师id和新邮箱
     * @return 成功1，失败0
     */
    int changeEmail(Teacher teacher);

    /**
     * 删除教师
     * @param teacher 教师
     * @return 成功1，失败0
     */
    int deleteTeacher(Teacher teacher);
}
