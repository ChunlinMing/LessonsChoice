package com.mcl.bysj.action;

import com.mcl.bysj.entity.LoginInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

/**
 * 用于登录的控制器
 * Created by mingchunlin on 17/4/10.
 */
@Controller
public class LoginAction
{
    private static Logger logger = Logger.getLogger(LoginAction.class);

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String loginCheck()
    {
        return "login";
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String loginCheck(HttpSession session,@RequestBody LoginInfo loginInfo,@RequestParam String length)
    {
        return "login";
    }
}
