package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.ScoreLimitDao;
import com.mcl.bysj.entity.ScoreLimit;
import com.mcl.bysj.service.ScoreLimitService;
import com.mcl.bysj.vo.ChangeScoreLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 更改选课学分上限逻辑实现
 * Created by mingchunlin on 17/4/21.
 */
@Service
public class ScoreLimitServiceImpl implements ScoreLimitService
{
    @Autowired
    ScoreLimitDao scoreLimitDao;

    /**
     * 更改选课学分上限
     * @param changeScoreLimit 更改选课学分上限对象
     * @return 成功1，失败-1
     */
    public int updateScoreLimit(ChangeScoreLimit changeScoreLimit)
    {
        return scoreLimitDao.updateScoreLimit(changeScoreLimit);
    }

    /**
     * 查找当前学分上限
     * @return 当前学分上限的集合（只有一个元素）
     */
    public List<ScoreLimit> findAllScoreLimits()
    {
        return scoreLimitDao.findAllScoreLimits();
    }
}
