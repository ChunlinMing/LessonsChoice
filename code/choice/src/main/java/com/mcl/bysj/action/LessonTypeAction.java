package com.mcl.bysj.action;

import com.mcl.bysj.entity.LessonType;
import com.mcl.bysj.service.LessonTypeService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeLessonType;
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
 * 管理员操作课程类型
 * Created by mingchunlin on 17/4/21.
 */
@Controller
public class LessonTypeAction
{
    @Autowired
    LessonTypeService lessonTypeService;

    @RequestMapping(value = "/addLessonType", method = RequestMethod.GET)
    public String addLessonTypePage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<LessonType> lessonTypeList = lessonTypeService.findAllLessonTypes();
                model.addAttribute("lessonTypeList",lessonTypeList);
                return "manager/addLessonType";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addLessonType", method = RequestMethod.POST)
    @ResponseBody
    public int addLessonType(HttpServletResponse response, LessonType lessonType)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != lessonType && !Helper.isEmpty(lessonType.getLessonTypeName()))
        {
            return lessonTypeService.insertLessonType(lessonType);
        }
        return -1;
    }

    @RequestMapping(value = "/changeLessonType", method = RequestMethod.GET)
    public String changeLessonTypePage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<LessonType> lessonTypeList = lessonTypeService.findAllLessonTypes();
                model.addAttribute("lessonTypeList",lessonTypeList);
                return "manager/changeLessonType";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeLessonType", method = RequestMethod.POST)
    @ResponseBody
    public int changeLessonType(HttpServletResponse response, ChangeLessonType changeLessonType)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeLessonType && !Helper.isEmpty(changeLessonType.getLessonTypeAfter())
                && !Helper.isEmpty(changeLessonType.getLessonTypeBefore()))
        {
            return lessonTypeService.updateLessonType(changeLessonType);
        }
        return -1;
    }
}
