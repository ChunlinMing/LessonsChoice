package com.mcl.bysj.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于登录的控制器
 * Created by mingchunlin on 17/4/10.
 */
@Controller
public class LoginAction
{
    private static Logger logger = Logger.getLogger("LoginAction");

    @RequestMapping(value="/")
    public String loginCheck()
    {
        return "login";
    }
}
