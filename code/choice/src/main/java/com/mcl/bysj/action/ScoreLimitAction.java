package com.mcl.bysj.action;

import com.mcl.bysj.entity.ScoreLimit;
import com.mcl.bysj.service.ScoreLimitService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeScoreLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员更改选课学分上限
 * Created by mingchunlin on 17/4/21.
 */
@Controller
public class ScoreLimitAction
{
    @Autowired
    private ScoreLimitService scoreLimitService;

    @RequestMapping(value = "/changeScoreLimit", method = RequestMethod.GET)
    public String changeScoreLimitPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<ScoreLimit> scoreLimitList = scoreLimitService.findAllScoreLimits();
                model.addAttribute("scoreLimitList",scoreLimitList);
                return "manager/changeScoreLimit";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeScoreLimit", method = RequestMethod.POST)
    @ResponseBody
    public int changeScoreLimit(HttpServletResponse response, ChangeScoreLimit changeScoreLimit)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeScoreLimit && null != changeScoreLimit.getScoreLimitAfter()
                && null != changeScoreLimit.getScoreLimitBefore())
        {
            return scoreLimitService.updateScoreLimit(changeScoreLimit);
        }
        return 0;
    }
}
