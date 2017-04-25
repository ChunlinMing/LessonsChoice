package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.TermDao;
import com.mcl.bysj.entity.Term;
import com.mcl.bysj.service.TermService;
import com.mcl.bysj.vo.ChangeTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学期服务实现类
 * Created by mingchunlin on 17/4/20.
 */
@Service
public class TermServiceImpl implements TermService
{
    @Autowired
    private TermDao termDao;

    /**
     * 添加学期
     * @param term 学期
     * @return 插入是否成功，成功1，失败0，要插入的数据已存在-100
     */
    public int insertTerm(Term term)
    {
        if (null == termDao.findTermByTerm(term))
        {
            return termDao.insertTerm(term);
        }
        return -100;
    }

    /**
     * 更改学期
     * @param changeTerm 更改学期对象
     * @return 更改成功返回1，失败0，要更改为的学期已存在，返回-100
     */
    public int updateTerm(ChangeTerm changeTerm)
    {
        Term myTerm = new Term();
        myTerm.setTerm(changeTerm.getTermAfter());
        if (null == termDao.findTermByTerm(myTerm))
        {
            return termDao.updateTerm(changeTerm);
        }
        return -100;
    }

    /**
     * 查找所有学期数据
     * @return 学期集合
     */
    public List<Term> findAllTerms()
    {
        return termDao.findAllTerms();
    }
}
