package com.mcl.bysj.service.impl;

import com.github.pagehelper.PageHelper;
import com.mcl.bysj.dao.LoginInfoDao;
import com.mcl.bysj.dao.StuDao;
import com.mcl.bysj.entity.LoginInfo;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.service.StudentService;
import com.mcl.bysj.vo.ChangeStu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生操作逻辑实现
 * Created by mingchunlin on 17/4/24.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StuDao stuDao;

    @Autowired
    private LoginInfoDao loginInfoDao;

    /**
     * 根据学号查找学生
     *
     * @param student 包含学号的对象
     * @return 查找结果
     */
    public Student findStudent(Student student) {
        return stuDao.findStudent(student);
    }

    /**
     * 根据班级查找学生
     *
     * @param stuClass 班级对象
     * @return 查找到的学生集合
     */
    public List<Student> findAllStudentByStuClass(StuClass stuClass) {
        return stuDao.findAllStudentByStuClass(stuClass);
    }

    public List<Student> findAllStudent(int page)
    {
        PageHelper.startPage(page, 15);
        return stuDao.findAllStudent();
    }

    /**
     * 添加学生
     *
     * @param student 学生
     * @return 成功1，失败0，已存在-100
     */
    public int insertStudent(Student student) {
        if (null == stuDao.findStudent(student)) {
            return stuDao.insertStudent(student);
        }
        return -100;
    }

    /**
     * 更改学生信息
     *
     * @param changeStu 更改学生信息对象
     * @return 成功1，失败0，已存在-100
     */
    public int updateStudent(ChangeStu changeStu) {
        Student student = new Student();
        student.setStuId(changeStu.getStuIdAfter());
        if (changeStu.getStuIdAfter().equals(changeStu.getStuIdBefore())) {
            student.setStuName(changeStu.getStuNameAfter());
            student.setStuGender(changeStu.getStuGenderAfter());
            student.setGradeYear(changeStu.getGradeYearAfter());
            student.setStuClass(changeStu.getStuClassAfter());
            student.setStuSchool(changeStu.getStuSchoolAfter());
            student.setStuEmail(changeStu.getStuEmailAfter());
            if (null == stuDao.findStudentByEntity(student)) {
                return stuDao.updateStudent(changeStu);
            }
        } else {
            if (null == stuDao.findStudent(student)) {
                return stuDao.updateStudent(changeStu);
            }
        }
        return -100;
    }

    /**
     * 更改学生邮箱
     * @param student 学生ID和新邮箱
     * @return 成功1，失败0，不存在-200
     */
    public int changeEmail(Student student)
    {
        if (null != stuDao.findStudent(student))
        {
            return stuDao.changeEmail(student);
        }
        return -200;
    }

    /**
     * 删除学生
     *
     * @param student 学生
     * @return 成功1，失败0，不存在-200
     */
    public int deleteStudent(Student student)
    {
        if (null != stuDao.findStudent(student))
        {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setUserId(student.getStuId());
            if (null != loginInfoDao.findUserById(loginInfo))
            {
                int deleteRes = loginInfoDao.deleteUser(student.getStuId());
                if (1 == deleteRes)
                {
                    return stuDao.deleteStudent(student);
                }
                else
                {
                    return 0;
                }
            }
            return stuDao.deleteStudent(student);
        }
        return -200;
    }
}
