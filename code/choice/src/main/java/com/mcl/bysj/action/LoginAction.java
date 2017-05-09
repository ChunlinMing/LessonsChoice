package com.mcl.bysj.action;

import com.mcl.bysj.entity.*;
import com.mcl.bysj.service.*;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.UpdateValidationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于登录的控制器
 * Created by mingchunlin on 17/4/10.
 */
@Controller
public class LoginAction
{
    @Autowired
    private LoginInfoService loginInfoService;

    @Autowired
    private ValidationCodeService validationCodeService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TeacherFuncService teacherFuncService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private LessonTypeService lessonTypeService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private GradeYearService gradeYearService;

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

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUpPage()
    {
        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String SignUp(@ModelAttribute LoginInfo loginInfo, @RequestParam int length,
                         @RequestParam String code, Model model)
    {
        if (null != loginInfo && !Helper.isEmpty(code) && length > 0)
        {
            ValidationCode validationCode = new ValidationCode();
            validationCode.setUserId(loginInfo.getUserId());
            validationCode.setValidationCode(code);
            validationCode.setExpireFlag(false);
            ValidationCode findCodeResult = validationCodeService.findValidationCode(validationCode);
            UpdateValidationCode updateValidationCode = new UpdateValidationCode();
            updateValidationCode.setUserId(loginInfo.getUserId());
            updateValidationCode.setExpireFlagBefore(false);
            updateValidationCode.setExpireFlagAfter(true);
            validationCodeService.updateValidationCode(updateValidationCode);
            if (null != findCodeResult)
            {
                loginInfo.setUserType(loginInfoService.findUserById(loginInfo));
                loginInfo.setUserPwd(Helper.EncodePwd(loginInfo.getUserPwd(),length));
                if (1 == loginInfoService.insertUser(loginInfo))
                {
                    model.addAttribute("userResult","注册成功！");
                    return "success";
                }
            }
            else
            {
                model.addAttribute("codeResult","验证码错误，请点击“发送邮件验证码”按钮重新获取验证码！");
            }
        }
        return "signUp";
    }

    @RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
    public String forgotPasswordPage()
    {
        return "forgotPwd";
    }

    @RequestMapping(value = "resetPwd", method = RequestMethod.POST)
    public String resetPwd(HttpServletRequest request, @ModelAttribute LoginInfo loginInfo,
                           @RequestParam int length, @RequestParam String code, Model model)
    {
        if (null != loginInfo && !Helper.isEmpty(code) && length > 0)
        {
            ValidationCode validationCode = new ValidationCode();
            validationCode.setUserId(loginInfo.getUserId());
            validationCode.setValidationCode(code);
            validationCode.setExpireFlag(false);
            ValidationCode findCodeResult = validationCodeService.findValidationCode(validationCode);
            UpdateValidationCode updateValidationCode = new UpdateValidationCode();
            updateValidationCode.setUserId(loginInfo.getUserId());
            updateValidationCode.setExpireFlagBefore(false);
            updateValidationCode.setExpireFlagAfter(true);
            validationCodeService.updateValidationCode(updateValidationCode);
            if (null != findCodeResult)
            {
                loginInfo.setUserPwd(Helper.EncodePwd(loginInfo.getUserPwd(),length));
                if (1 == loginInfoService.updateUser(loginInfo))
                {
                    model.addAttribute("userResult","更改密码成功！");
                    if (null != request.getSession(false))
                    {
                        request.getSession().invalidate();
                    }
                    return "success";
                }
            }
            else
            {
                model.addAttribute("codeResult","验证码错误，请点击“发送邮件验证码”按钮重新获取验证码！");
            }
        }
        if (null != request.getSession(false))
        {
            return "resetPwd";
        }
        return "forgotPwd";
    }

    @RequestMapping(value = "sendSignUpMail", method = RequestMethod.POST)
    @ResponseBody
    public int sendSignUpMail(HttpServletResponse response, LoginInfo loginInfo)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != loginInfo && !Helper.isEmpty(loginInfo.getUserId()))
        {
            int res = loginInfoService.findUserById(loginInfo);
            if (1 == res || 2 == res)
            {
                ValidationCode validationCode = new ValidationCode();
                validationCode.setExpireFlag(false);
                validationCode.setUserId(loginInfo.getUserId());
                List<ValidationCode> list = validationCodeService.findUnExpiredCode(validationCode);
                if (null != list)
                {
                    UpdateValidationCode updateValidationCode = new UpdateValidationCode();
                    updateValidationCode.setUserId(loginInfo.getUserId());
                    updateValidationCode.setExpireFlagAfter(true);
                    updateValidationCode.setExpireFlagBefore(false);
                    validationCodeService.updateValidationCode(updateValidationCode);
                }

                String code = Helper.produceValidationCode();
                validationCode.setValidationCode(code);
                int insertResult = validationCodeService.insertValidationCode(validationCode);
                if (1 == insertResult)
                {
                    try{
                        mailSender.send(Helper.mailConfig(validationCodeService.findEmail(loginInfo.getUserId()),
                                loginInfo.getUserId(), code));
                    }
                    catch (Exception e)
                    {
                        System.out.println("邮件发送失败！！"+e.toString());
                        return -1000;
                    }
                }
                else
                {
                    return insertResult;
                }
            }
            else
            {
                return res;
            }
        }
        else
        {
            return 0;
        }
        return 1;
    }

    @RequestMapping(value = "sendResetPwdMail", method = RequestMethod.POST)
    @ResponseBody
    public int sendResetPwdMail(HttpServletResponse response, LoginInfo loginInfo)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != loginInfo && !Helper.isEmpty(loginInfo.getUserId()))
        {
            int res = loginInfoService.findUserById(loginInfo);
            if (-100 == res)
            {
                ValidationCode validationCode = new ValidationCode();
                validationCode.setUserId(loginInfo.getUserId());
                validationCode.setExpireFlag(false);
                List<ValidationCode> list = validationCodeService.findUnExpiredCode(validationCode);
                if (null != list)
                {
                    UpdateValidationCode updateValidationCode = new UpdateValidationCode();
                    updateValidationCode.setUserId(loginInfo.getUserId());
                    updateValidationCode.setExpireFlagBefore(false);
                    updateValidationCode.setExpireFlagAfter(true);
                    validationCodeService.updateValidationCode(updateValidationCode);
                }
                String code = Helper.produceValidationCode();
                validationCode.setValidationCode(code);
                int insertResult = validationCodeService.insertValidationCode(validationCode);
                if (1 == insertResult)
                {
                    try {
                        mailSender.send(Helper.mailConfig(validationCodeService.findEmail(loginInfo.getUserId()),
                                loginInfo.getUserId(), code));
                    }
                    catch (Exception e)
                    {
                        System.out.println("邮件发送失败！"+e.toString());
                        return -1000;
                    }

                }
                else
                {
                    return insertResult;
                }
            }
            else if (1 == res || 2 == res)
            {
                return 2;
            }
            else
            {
                return res;
            }
        }
        else
        {
            return 0;
        }
        return 1;
    }

    @RequestMapping(value="/manager")
    public String manager(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                return "manager/manager";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String showLesson(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(1))
            {
                String id = request.getSession().getAttribute("userId").toString();
                List<LessonInfo> lessonList = teacherFuncService.findLessonByTeacher(id);
                List<Building> buildingList = buildingService.findAllBuildings();
                List<LessonType> lessonTypeList = lessonTypeService.findAllLessonTypes();
                List<GradeYear> gradeYears = gradeYearService.findAllGradeYears();
                List<School> schoolList = schoolService.findAllSchools();
                List<GradeYear> gradeYearList = new ArrayList<>(1);
                for (int i = 0; i < gradeYears.size(); i++)
                {
                    gradeYearList.add(gradeYears.get(gradeYears.size() - i - 1));
                }
                gradeYears = null;

                model.addAttribute("userId",id);
                model.addAttribute("buildingList",buildingList);
                model.addAttribute("lessonTypeList",lessonTypeList);
                model.addAttribute("gradeYearList",gradeYearList);
                model.addAttribute("schoolList",schoolList);
                model.addAttribute("lessonList",lessonList);
                return "teacher/showLesson";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }
}
