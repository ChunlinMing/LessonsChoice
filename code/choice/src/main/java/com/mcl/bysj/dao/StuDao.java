package com.mcl.bysj.dao;

import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.vo.ChangeStu;

import java.util.List;

/**
 * 学生操作dao接口
 * Created by mingchunlin on 17/4/24.
 */
public interface StuDao
{
    /**
     * 根据学号查找学生
     * @param student 包含学号的对象
     * @return 查找结果
     */
    Student findStudent(Student student);

    /**
     * 根据学生对象查找学生
     * @param student 学生对象
     * @return 查找结果
     */
    Student findStudentByEntity(Student student);

    /**
     * 根据班级查找学生
     * @param stuClass 班级对象
     * @return 查找到的学生集合
     */
    List<Student> findAllStudentByStuClass(StuClass stuClass);

    /**
     * 查找所有学生
     * @return 学生集合
     */
    List<Student> findAllStudent();

    /**
     * 添加学生
     * @param student 学生
     * @return 成功1，失败0
     */
    int insertStudent(Student student);

    /**
     * 更改学生信息
     * @param changeStu 更改学生信息对象
     * @return 成功1，失败0
     */
    int updateStudent(ChangeStu changeStu);

    /**
     * 更改学生邮箱
     * @param student 学生id和新邮箱
     * @return 成功1，失败0
     */
    int changeEmail(Student student);

    /**
     * 删除学生
     * @param student 学生
     * @return 成功1，失败0
     */
    int deleteStudent(Student student);
}
