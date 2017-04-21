package com.mcl.bysj.dao;

import com.mcl.bysj.entity.Term;
import com.mcl.bysj.vo.ChangeTerm;

import java.util.List;

/**
 * 对学期进行相关操作的dao接口
 * Created by mingchunlin on 17/4/20.
 */
public interface TermDao
{
    /**
     * 根据学期查询该学期是否存在
     * @param term 学期
     * @return 查询结果
     */
    Integer findTermByTerm(Term term);

    /**
     * 插入学期
     * @param term 学期
     * @return 插入是否成功，成功1，失败0
     */
    int insertTerm(Term term);

    /**
     * 更改学期
     * @param changeTerm 更改学期对象
     * @return 更改成功返回1，失败0
     */
    int updateTerm(ChangeTerm changeTerm);

    /**
     * 查询所有学期数据
     * @return 学期集合
     */
    List<Term> findAllTerms();
}
