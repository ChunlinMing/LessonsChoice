package com.mcl.bysj.dao;

import com.mcl.bysj.entity.ScoreLimit;
import com.mcl.bysj.vo.ChangeScoreLimit;

import java.util.List;

/**
 * 选课学分上限dao接口
 * Created by mingchunlin on 17/4/21.
 */
public interface ScoreLimitDao
{
    /**
     * 更改选课学分上限
     * @param scoreLimit 学分上限
     * @return 更改成功1，失败-1
     */
    int updateScoreLimit(ChangeScoreLimit changeScoreLimit);

    /**
     * 查询当前学分上限
     * @return 只有一个元素的学分上限List
     */
    List<ScoreLimit> findAllScoreLimits();
}
