package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.StuFuncDao;
import com.mcl.bysj.dao.TeacherLessonDao;
import com.mcl.bysj.entity.LessonChoice;
import com.mcl.bysj.entity.LessonInfo;
import com.mcl.bysj.service.StuFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生功能逻辑实现
 * Created by 明春霖! on 17/5/20.
 */
@Service
public class StuFuncServiceImpl implements StuFuncService
{
    @Autowired
    private TeacherLessonDao teacherLessonDao;

    @Autowired
    private StuFuncDao stuFuncDao;

    /**
     * 查找最新的选修课
     * @param lessonInfo 查找条件：学期和课程类型
     * @return 选修课集合
     */
    public List<LessonInfo> findOptionalLesson(LessonInfo lessonInfo)
    {
        return teacherLessonDao.findOptionalLesson(lessonInfo);
    }

    /**
     * 根据学院、年级和上课学期查找课程
     * @param lessonInfo 查找条件：年级、学期和学院
     * @return 课程集合
     */
    public List<LessonInfo> findRequiredLesson(LessonInfo lessonInfo)
    {
        return teacherLessonDao.findRequiredLesson(lessonInfo);
    }

    /**
     * 根据ID查找课程
     * @param lessonId 课程ID
     * @return 课程对象
     */
    public LessonInfo findLessonById(String lessonId)
    {
        return teacherLessonDao.findLessonById(lessonId);
    }

    /**
     * 根据课程ID和学号查找已选择的课程
     * @param lessonChoice 课程ID和学号
     * @return 选课对象
     */
    public LessonChoice findLessonChoiceById(LessonChoice lessonChoice)
    {
        return stuFuncDao.findLessonChoiceById(lessonChoice);
    }

    /**
     * 查找某学生的所有最新的已选课程
     * @param lessonChoice 学号和上课学期
     * @return 选课集合
     */
    public List<LessonChoice> findAllLessonChoice(LessonChoice lessonChoice)
    {
        return stuFuncDao.findAllLessonChoice(lessonChoice);
    }

    /**
     * 添加新选的课程
     * @param lessonChoice 选课对象
     * @return 成功1，失败0
     */
    public int addLessonChoice(LessonChoice lessonChoice)
    {
        return stuFuncDao.addLessonChoice(lessonChoice);
    }

    /**
     * 更改某课程已选人数
     * @param lessonInfo 课程号和已选人数
     * @return 成功1，失败0
     */
    public int updateChoseStu(LessonInfo lessonInfo)
    {
        return stuFuncDao.updateChoseStu(lessonInfo);
    }

    /**
     * 删除已选择的课程
     * @param lessonChoice 学号和课程号
     * @return 成功1，失败0，不存在-200
     */
    public int deleteLessonChoice(LessonChoice lessonChoice)
    {
        if (null != stuFuncDao.findLessonChoiceById(lessonChoice))
        {
            return stuFuncDao.deleteLessonChoice(lessonChoice);
        }
        return -200;
    }
}
