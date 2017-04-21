package com.mcl.bysj.dao;

import com.mcl.bysj.entity.GradeYear;
import com.mcl.bysj.vo.ChangeGradeYear;

import java.util.List;

/**
 * 年级实体dao接口
 * Created by mingchunlin on 17/4/21.
 */
public interface GradeYearDao
{
    /**
     * 查找指定的年级
     * @param gradeYear 年级
     * @return 查找到的年级
     */
    Integer findGradeYear(GradeYear gradeYear);

    /**
     * 添加年级
     * @param gradeYear 年级
     * @return 添加是否成功，成功1，失败-1
     */
    int insertGradeYear(GradeYear gradeYear);

    /**
     * 查找所有年级
     * @return 年级集合
     */
    List<GradeYear> findAllGradeYears();

    /**
     * 更改年级
     * @param changeGradeYear 更改年级对象
     * @return 更改该成功1，失败-1
     */
    int updateGradeYear(ChangeGradeYear changeGradeYear);
}
