package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.GradeYearDao;
import com.mcl.bysj.entity.GradeYear;
import com.mcl.bysj.service.GradeYearService;
import com.mcl.bysj.vo.ChangeGradeYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 年级操作逻辑实现
 * Created by mingchunlin on 17/4/21.
 */
@Service
public class GradeYearServiceImpl implements GradeYearService
{
    @Autowired
    GradeYearDao gradeYearDao;

    /**
     * 添加年级
     * @param gradeYear 年级
     * @return 添加成功1，失败-1，已存在-100
     */
    public int insertGradeYear(GradeYear gradeYear)
    {
        if (null == gradeYearDao.findGradeYear(gradeYear))
        {
            return gradeYearDao.insertGradeYear(gradeYear);
        }
        return -100;
    }

    /**
     * 查找所有年级
     * @return 年级集合
     */
    public List<GradeYear> findAllGradeYears()
    {
        return gradeYearDao.findAllGradeYears();
    }

    /**
     * 更改年级
     * @param changeGradeYear 更改年级对象
     * @return 成功1，失败-1，已存在-100
     */
    public int updateGradeYear(ChangeGradeYear changeGradeYear)
    {
        GradeYear gradeYear = new GradeYear();
        gradeYear.setGradeYear(changeGradeYear.getGradeYearAfter());
        if (null == gradeYearDao.findGradeYear(gradeYear))
        {
            return gradeYearDao.updateGradeYear(changeGradeYear);
        }
        return -100;
    }
}
