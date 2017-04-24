package com.mcl.bysj.dao;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.entity.Classroom;
import com.mcl.bysj.vo.ChangeClassroom;

import java.util.List;

/**
 * 教室dao接口
 * Created by mingchunlin on 17/4/23.
 */
public interface ClassroomDao
{
    /**
     * 查找指定的教室
     * @param classroom 教室
     * @return 查找结果
     */
    Classroom findClassroom(Classroom classroom);

    /**
     * 根据教室和教学楼查找教室
     * @param classroom 教室和教学楼对象
     * @return 查找结果
     */
    Classroom findClassroomByEntity(Classroom classroom);

    /**
     * 根据教学楼查找教室
     * @param building 教学楼
     * @return 指定教学楼下的教室集合
     */
    List<Classroom> findAllClassroomByBuilding(Building building);

    /**
     * 添加教室
     * @param classroom 教室
     * @return 成功1，失败0
     */
    int insertClassroom(Classroom classroom);

    /**
     * 更新教室信息
     * @param changeClassroom 更改教室信息实体对象
     * @return 成功1，失败0
     */
    int updateClassroom(ChangeClassroom changeClassroom);

    /**
     * 删除教室
     * @param classroom 教室对象
     * @return 成功1，失败0
     */
    int deleteClassroom(Classroom classroom);
}
