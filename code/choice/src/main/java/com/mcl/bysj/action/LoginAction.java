package com.mcl.bysj.action;

import com.mcl.bysj.entity.LoginInfo;
import com.mcl.bysj.service.LoginInfoService;
import com.mcl.bysj.utils.Helper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用于登录的控制器
 * Created by mingchunlin on 17/4/10.
 */
@Controller
public class LoginAction
{
    private static Logger logger = Logger.getLogger(LoginAction.class);

    @Autowired
    private LoginInfoService loginInfoService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String login(HttpServletRequest request)
    {
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String loginCheck(HttpServletRequest request, @ModelAttribute LoginInfo loginInfo, @RequestParam int length, Model model)
    {
        if (null != loginInfo && length > 0)
        {
            loginInfo.setUserPwd(Helper.EncodePwd(loginInfo.getUserPwd(),length));
            Integer userType = loginInfoService.findUserType(loginInfo);
            boolean loginStatus = Helper.checkUserType(userType,loginInfo,request.getSession());
            if (loginStatus)
            {
                return Helper.checkUserType(userType);
            }
            else
            {
                model.addAttribute("loginResult","用户名或密码不正确，请重新输入！");
            }
        }
        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        return "redirect:/";
    }

    @RequestMapping(value="/manager")
    public String addTerm(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                return "manager/addTerm";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }
}
