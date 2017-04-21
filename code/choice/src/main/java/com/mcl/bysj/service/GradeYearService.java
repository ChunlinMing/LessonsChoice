package com.mcl.bysj.service;

import com.mcl.bysj.entity.GradeYear;
import com.mcl.bysj.vo.ChangeGradeYear;

import java.util.List;

/**
 * 年级操作逻辑接口
 * Created by mingchunlin on 17/4/21.
 */
public interface GradeYearService
{
    int insertGradeYear(GradeYear gradeYear);

    List<GradeYear> findAllGradeYears();

    int updateGradeYear(ChangeGradeYear changeGradeYear);
}
