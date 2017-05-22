package com.mcl.bysj.service;

import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.StuGrade;

import java.util.List;

/**
 * 成绩操作相关逻辑接口
 * Created by 明春霖 on 17/5/22.
 */
public interface StuGradeService
{
    List<LessonChoice> findLessonChoiceByLessonId(String lessonId);

    List<StuGrade> findStuGradeByLessonId(String lessonId);

    int addStuGrade(StuGrade stuGrade);

    List<StuGrade> findStuGradeByTerm(StuGrade stuGrade);

    List<StuGrade> findStuGradeByStuId(String stuId);
}
