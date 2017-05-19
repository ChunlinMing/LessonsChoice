package com.mcl.bysj.service;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.vo.ChangeTeacher;

import java.util.List;

/**
 * 教师操作逻辑接口
 * Created by mingchunlin on 17/4/24.
 */
public interface TeacherService
{
    Teacher findTeacher(Teacher teacher);

    List<Teacher> findAllTeacherBySchool(School school);

    List<Teacher> findAllTeacher(int page);

    int insertTeacher(Teacher teacher);

    int updateTeacher(ChangeTeacher changeTeacher);

    int deleteTeacher(Teacher teacher);
}
