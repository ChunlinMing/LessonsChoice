package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.LessonTypeDao;
import com.mcl.bysj.entity.LessonType;
import com.mcl.bysj.service.LessonTypeService;
import com.mcl.bysj.vo.ChangeLessonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程类型逻辑操作实现类
 * Created by mingchunlin on 17/4/21.
 */
@Service
public class LessonTypeServiceImpl implements LessonTypeService
{
    @Autowired
    LessonTypeDao lessonTypeDao;

    /**
     * 添加课程类型
     * @param lessonType 课程类型对象
     * @return 添加成功返回1，失败0，已存在-100
     */
    public int insertLessonType(LessonType lessonType)
    {
        if (null == lessonTypeDao.findLessonType(lessonType))
        {
            return lessonTypeDao.insertLessonType(lessonType);
        }
        return -100;
    }

    /**
     * 查找所有课程类型
     * @return 课程类型集合
     */
    public List<LessonType> findAllLessonTypes()
    {
        return lessonTypeDao.findAllLessonTypes();
    }

    /**
     * 更改课程类型
     * @param changeLessonType 更改课程类型对象
     * @return 更改成功返回1，失败0，已存在-100
     */
    public int updateLessonType(ChangeLessonType changeLessonType)
    {
        LessonType lessonType = new LessonType();
        lessonType.setLessonTypeName(changeLessonType.getLessonTypeAfter());
        if (null == lessonTypeDao.findLessonType(lessonType))
        {
            return lessonTypeDao.updateLessonType(changeLessonType);
        }
        return -100;
    }

    /**
     * 删除课程类型
     * @param lessonType 课程类型
     * @return 成功1，失败0
     */
    public int deleteLessonType(LessonType lessonType)
    {
        return lessonTypeDao.deleteLessonType(lessonType);
    }
}
