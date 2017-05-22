package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.StuGrade;

import java.util.List;

/**
 * 成绩操作Dao接口
 * Created by 明春霖 on 17/5/22.
 */
public interface StuGradeDao
{
    /**
     * 查找学习某门课程的学生
     * @param lessonId 课程ID
     * @return 选课集合
     */
    List<LessonChoice> findLessonChoiceByLessonId(String lessonId);

    /**
     * 查找选择某门课程的学生的成绩
     * @param lessonId 课程ID
     * @return 成绩集合
     */
    List<StuGrade> findStuGradeByLessonId(String lessonId);

    /**
     * 根据学号和上课学期查找成绩
     * @param stuGrade 学号和上课学期
     * @return 成绩信息集合
     */
    List<StuGrade> findStuGradeByTerm(StuGrade stuGrade);

    /**
     * 根据学号查找该生的所有成绩
     * @param stuId 学号
     * @return 成绩信息集合
     */
    List<StuGrade> findStuGradeByStuId(String stuId);

    /**
     * 添加学生成绩
     * @param stuGrade 成绩信息对象
     * @return 成功1，失败0
     */
    int addStuGrade(StuGrade stuGrade);
}
