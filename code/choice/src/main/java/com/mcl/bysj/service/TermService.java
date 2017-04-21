package com.mcl.bysj.service;

import com.mcl.bysj.entity.Term;
import com.mcl.bysj.vo.ChangeTerm;

import java.util.List;

/**
 * 学期操作服务接口
 * Created by mingchunlin on 17/4/20.
 */
public interface TermService
{
    int insertTerm(Term term);

    int updateTerm(ChangeTerm changeTerm);

    List<Term> findAllTerms();
}

