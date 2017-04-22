package com.mcl.bysj.dao;

import com.mcl.bysj.entity.LessonType;
import com.mcl.bysj.vo.ChangeLessonType;

import java.util.List;

/**
 * 课程类型dao接口
 * Created by mingchunlin on 17/4/21.
 */
public interface LessonTypeDao
{
    /**
     * 查找指定的课程类型
     * @param lessonType 课程类型对象
     * @return 查找结果
     */
    String findLessonType(LessonType lessonType);

    /**
     * 添加课程类型
     * @param lessonType 课程类型对象
     * @return 添加成功1，失败0
     */
    int insertLessonType(LessonType lessonType);

    /**
     * 查找所有课程类型
     * @return 课程类型集合
     */
    List<LessonType> findAllLessonTypes();

    /**
     * 更改课程类型
     * @param changeLessonType 更改课程类型对象
     * @return 更改成功1，失败0
     */
    int updateLessonType(ChangeLessonType changeLessonType);

    /**
     * 删除课程类型
     * @param lessonType 课程类型
     * @return 删除成功1，失败0
     */
    int deleteLessonType(LessonType lessonType);
}
