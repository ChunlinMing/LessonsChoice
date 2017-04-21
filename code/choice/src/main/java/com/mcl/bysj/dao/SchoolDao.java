package com.mcl.bysj.dao;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.vo.ChangeSchool;

import java.util.List;

/**
 * 学院操作dao接口
 * Created by mingchunlin on 17/4/21.
 */
public interface SchoolDao
{
    /**
     * 查找指定的学院
     * @param school 学院
     * @return 查找结果
     */
    String findSchool(School school);

    /**
     * 查找所有学院
     * @return 学院集合
     */
    List<School> findAllSchools();

    /**
     * 添加学院
     * @param school 学院
     * @return 添加成功1，失败0
     */
    int insertSchool(School school);

    /**
     * 更改学院名称
     * @param changeSchool 更改学院名称对象
     * @return 更改成功1，更改失败0
     */
    int updateSchool(ChangeSchool changeSchool);

    /**
     * 删除学院
     * @param school 学院
     * @return 删除成功1，失败0
     */
    int deleteSchool(School school);
}
