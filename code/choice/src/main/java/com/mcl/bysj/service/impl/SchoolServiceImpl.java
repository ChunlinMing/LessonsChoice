package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.SchoolDao;
import com.mcl.bysj.entity.School;
import com.mcl.bysj.service.SchoolService;
import com.mcl.bysj.vo.ChangeSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理学院名称逻辑实现
 * Created by mingchunlin on 17/4/21.
 */
@Service
public class SchoolServiceImpl implements SchoolService
{
    @Autowired
    SchoolDao schoolDao;

    /**
     * 查找所有学院
     * @return 学院集合
     */
    public List<School> findAllSchools()
    {
        return schoolDao.findAllSchools();
    }

    /**
     * 添加学院
     * @param school 学院
     * @return 添加成功1，失败0，已存在-100
     */
    public int insertSchool(School school)
    {
        if (null == schoolDao.findSchool(school))
        {
            return schoolDao.insertSchool(school);
        }
        return -100;
    }

    /**
     * 更改学院名称
     * @param changeSchool 更改学院名称对象
     * @return 更改成功1，失败0，已存在-100
     */
    public int updateSchool(ChangeSchool changeSchool)
    {
        School school = new School();
        school.setSchool(changeSchool.getSchoolAfter());
        if (null == schoolDao.findSchool(school))
        {
            return schoolDao.updateSchool(changeSchool);
        }
        return -100;
    }

    /**
     * 删除学院名称
     * @param school 学院
     * @return 删除成功1，失败0
     */
    public int deleteSchool(School school)
    {
        return schoolDao.deleteSchool(school);
    }
}
