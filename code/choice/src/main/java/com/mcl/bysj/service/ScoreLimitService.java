package com.mcl.bysj.service;

import com.mcl.bysj.entity.ScoreLimit;
import com.mcl.bysj.vo.ChangeScoreLimit;

import java.util.List;

/**
 * 更改选课学分上限逻辑接口
 * Created by mingchunlin on 17/4/21.
 */
public interface ScoreLimitService
{
    int updateScoreLimit(ChangeScoreLimit changeScoreLimit);

    List<ScoreLimit> findAllScoreLimits();
}
