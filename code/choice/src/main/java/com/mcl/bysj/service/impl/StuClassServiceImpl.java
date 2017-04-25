package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.StuClassDao;
import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.service.StuClassService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 教学班操作逻辑实现
 * Created by mingchunlin on 17/4/23.
 */
@Service
public class StuClassServiceImpl implements StuClassService
{
    @Autowired
    private StuClassDao stuClassDao;

    /**
     * 查找指定的教学班
     *
     * @param stuClass 教学班对象
     * @return 查找结果
     */
    public StuClass findClass(StuClass stuClass)
    {
        return stuClassDao.findClass(stuClass);
    }

    /**
     * 查找指定学院的所有班级
     *
     * @param school 学院
     * @return 班级集合
     */
    public List<StuClass> findAllClassBySchool(School school)
    {
        return stuClassDao.findAllClassBySchool(school);
    }

    /**
     * 添加新的教学班
     *
     * @param stuClass 教学班对象
     * @return 成功1，失败0，已存在-100
     */
    public int insertClass(StuClass stuClass)
    {
        if (null == stuClassDao.findClass(stuClass))
        {
            return stuClassDao.insertClass(stuClass);
        }
        return -100;
    }

    /**
     * 更改教学班信息
     *
     * @param changeClass 更改教学班对象
     * @return 成功1，失败0，已存在-100
     */
    public int updateClass(ChangeClass changeClass)
    {
        StuClass stuClass = new StuClass();
        stuClass.setStuClass(changeClass.getStuClassAfter());

        if (changeClass.getStuClassAfter().equals(changeClass.getStuClassBefore()))
        {
            stuClass.setSchool(changeClass.getSchoolAfter());
            if (null == stuClassDao.findClassByEntity(stuClass))
            {
                return stuClassDao.updateClass(changeClass);
            }
        }
        else
        {
            if (null == stuClassDao.findClass(stuClass))
            {
                return stuClassDao.updateClass(changeClass);
            }
        }

        return -100;
    }

    /**
     * 删除教学班
     *
     * @param stuClass 教学班对象
     * @return 成功1，失败0，要删除的班级不存在-200
     */
    public int deleteClass(StuClass stuClass)
    {
        StuClass result = stuClassDao.findClass(stuClass);
        if (null != result && !Helper.isEmpty(result.getStuClass()))
        {
            return stuClassDao.deleteClass(stuClass);
        }
        return -200;
    }
}
