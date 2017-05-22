package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.LessonInfo;

import java.util.List;

/**
 * 学生相关操作dao接口
 * Created by 明春霖 on 17/5/21.
 */
public interface StuFuncDao
{
    /**
     * 根据课程ID和学号查找选择的课程
     * @param lessonChoice 课程ID和学号
     * @return 选课对象
     */
    LessonChoice findLessonChoiceById(LessonChoice lessonChoice);

    /**
     * 查找某学生的所有最新的已选课程
     * @param lessonChoice 学号和上课学期
     * @return 选课集合
     */
    List<LessonChoice> findAllLessonChoice(LessonChoice lessonChoice);

    /**
     * 选课
     * @param lessonChoice 选课信息
     * @return 成功1，失败0
     */
    int addLessonChoice(LessonChoice lessonChoice);

    /**
     * 更改某课程已选人数
     * @param lessonInfo 课程号和已选人数
     * @return 成功1，失败0
     */
    int updateChoseStu(LessonInfo lessonInfo);

    /**
     * 删除已选择的课程
     * @param lessonChoice 学号和课程号
     * @return 成功1，失败0
     */
    int deleteLessonChoice(LessonChoice lessonChoice);
}
