package com.mcl.bysj.dao;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.vo.ChangeClass;

import java.util.List;

/**
 * 教学班实体dao接口
 * Created by mingchunlin on 17/4/23.
 */
public interface StuClassDao
{
    /**
     * 查找指定的教学班
     * @param stuClass 教学班对象
     * @return 查找结果
     */
    StuClass findClass(StuClass stuClass);

    /**
     * 根据指定教学班和学院查找教学班
     * @param stuClass 教学班和学院的实体对象
     * @return 查找结果
     */
    StuClass findClassByEntity(StuClass stuClass);

    /**
     * 查找指定学院的所有班级
     * @param school 学院
     * @return 班级集合
     */
    List<StuClass> findAllClassBySchool(School school);

    /**
     * 添加新的教学班
     * @param stuClass 教学班对象
     * @return 成功1，失败0
     */
    int insertClass(StuClass stuClass);

    /**
     * 更改教学班信息
     * @param changeClass 更改教学班对象
     * @return 成功1，失败0
     */
    int updateClass(ChangeClass changeClass);

    /**
     * 删除教学班
     * @param stuClass 教学班对象
     * @return 成功1，失败0
     */
    int deleteClass(StuClass stuClass);
}
