package com.mcl.bysj.service;

import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.vo.ChangeStu;

import java.util.List;

/**
 * 学生操作逻辑接口
 * Created by mingchunlin on 17/4/24.
 */
public interface StudentService
{
    Student findStudent(Student student);

    List<Student> findAllStudentByStuClass(StuClass stuClass);

    List<Student> findAllStudent(int page);

    int insertStudent(Student student);

    int updateStudent(ChangeStu changeStu);

    int deleteStudent(Student student);
}
