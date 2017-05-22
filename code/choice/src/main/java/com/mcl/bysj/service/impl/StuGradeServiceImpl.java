package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.StuGradeDao;
import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.StuGrade;
import com.mcl.bysj.service.StuGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成绩相关操作逻辑实现
 * Created by 明春霖 on 17/5/22.
 */
@Service
public class StuGradeServiceImpl implements StuGradeService
{
    @Autowired
    private StuGradeDao stuGradeDao;

    /**
     * 查找学习某门课程的学生
     * @param lessonId 课程ID
     * @return 选课集合
     */
    public List<LessonChoice> findLessonChoiceByLessonId(String lessonId)
    {
        return stuGradeDao.findLessonChoiceByLessonId(lessonId);
    }

    /**
     * 查找选择某门课程的学生的成绩
     * @param lessonId 课程ID
     * @return 成绩集合
     */
    public List<StuGrade> findStuGradeByLessonId(String lessonId)
    {
        return stuGradeDao.findStuGradeByLessonId(lessonId);
    }

    /**
     * 添加学生成绩
     * @param stuGrade 成绩信息对象
     * @return 成功1，失败0
     */
    public int addStuGrade(StuGrade stuGrade)
    {
        return stuGradeDao.addStuGrade(stuGrade);
    }

    /**
     * 根据学号和上课学期查找成绩
     * @param stuGrade 学号和上课学期
     * @return 成绩信息集合
     */
    public List<StuGrade> findStuGradeByTerm(StuGrade stuGrade)
    {
        return stuGradeDao.findStuGradeByTerm(stuGrade);
    }

    /**
     * 根据学号查找该生的所有成绩
     * @param stuId 学号
     * @return 成绩信息集合
     */
    public List<StuGrade> findStuGradeByStuId(String stuId)
    {
        return stuGradeDao.findStuGradeByStuId(stuId);
    }
}
