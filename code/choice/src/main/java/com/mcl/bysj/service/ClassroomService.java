package com.mcl.bysj.service;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.entity.Classroom;
import com.mcl.bysj.vo.ChangeClassroom;

import java.util.List;

/**
 * 教室操作逻辑接口
 * Created by mingchunlin on 17/4/23.
 */
public interface ClassroomService
{
    Classroom findClassroom(Classroom classroom);

    List<Classroom> findAllClassroomByBuilding(Building building);

    int insertClassroom(Classroom classroom);

    int updateClassroom(ChangeClassroom changeClassroom);

    int deleteClassroom(Classroom classroom);
}
