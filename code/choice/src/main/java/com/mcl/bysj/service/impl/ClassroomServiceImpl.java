package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.ClassroomDao;
import com.mcl.bysj.entity.Building;
import com.mcl.bysj.entity.Classroom;
import com.mcl.bysj.service.ClassroomService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教室操作逻辑实现
 * Created by mingchunlin on 17/4/23.
 */
@Service
public class ClassroomServiceImpl implements ClassroomService
{
    @Autowired
    ClassroomDao classroomDao;

    /**
     * 根据教学楼查找教室
     * @param building 教学楼
     * @return 返回教学楼下所有教室的集合
     */
    public List<Classroom> findAllClassroomByBuilding(Building building)
    {
        return classroomDao.findAllClassroomByBuilding(building);
    }

    /**
     * 新增教室
     * @param classroom 教室
     * @return 成功1，失败0，已存在-100
     */
    public int insertClassroom(Classroom classroom)
    {
        if (null == classroomDao.findClassroom(classroom))
        {
            return classroomDao.insertClassroom(classroom);
        }
        return -100;
    }

    /**
     * 更改教室信息
     * @param changeClassroom 更改教室实体对象
     * @return 成功1，失败0，已存在-100
     */
    public int updateClassroom(ChangeClassroom changeClassroom)
    {
        Classroom classroom = new Classroom();
        classroom.setClassroom(changeClassroom.getClassroomAfter());

        if (changeClassroom.getClassroomAfter().equals(changeClassroom.getClassroomBefore()))
        {
            classroom.setBuilding(changeClassroom.getBuildingAfter());
            if (null == classroomDao.findClassroomByEntity(classroom))
            {
                return classroomDao.updateClassroom(changeClassroom);
            }
        }
        else
        {
            if (null == classroomDao.findClassroom(classroom))
            {
                return classroomDao.updateClassroom(changeClassroom);
            }
        }
        return -100;
    }

    /**
     * 删除教室
     * @param classroom 教室
     * @return 成功1，失败0，不存在-200
     */
    public int deleteClassroom(Classroom classroom)
    {
        if (null != classroomDao.findClassroom(classroom))
        {
            return classroomDao.deleteClassroom(classroom);
        }
        return -200;
    }
}
