package com.mcl.bysj.action;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.service.SchoolService;
import com.mcl.bysj.service.StuClassService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeClass;
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
 * 管理员操作教学班
 * Created by mingchunlin on 17/4/23.
 */
@Controller
public class StuClassAction
{
    @Autowired
    private StuClassService stuClassService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/addClass", method = RequestMethod.GET)
    public String addClassPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/addClass";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addClass", method = RequestMethod.POST)
    @ResponseBody
    public int addClass(HttpServletResponse response, StuClass stuClass)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != stuClass && !Helper.isEmpty(stuClass.getStuClass())
                && !Helper.isEmpty(stuClass.getSchool()))
        {
            return stuClassService.insertClass(stuClass);
        }
        return 0;
    }

    @RequestMapping(value = "/changeClass", method = RequestMethod.GET)
    public String changeClassPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/changeClass";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeClass", method = RequestMethod.POST)
    @ResponseBody
    public int changeClass(HttpServletResponse response, ChangeClass changeClass)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeClass && !Helper.isEmpty(changeClass.getStuClassBefore()))
        {
            if (!Helper.isEmpty(changeClass.getStuClassAfter()) && !Helper.isEmpty(changeClass.getSchoolAfter())
                    && changeClass.getFlag() == 1)
            {
                return stuClassService.updateClass(changeClass);
            }
            else if (Helper.isEmpty(changeClass.getStuClassAfter()) && Helper.isEmpty(changeClass.getSchoolAfter())
                    && changeClass.getFlag() == 0)
            {
                StuClass stuClass = new StuClass();
                stuClass.setStuClass(changeClass.getStuClassBefore());
                return stuClassService.deleteClass(stuClass);
            }
        }
        return 0;
    }

    @RequestMapping(value = "findClassBySchool", method = RequestMethod.POST)
    @ResponseBody
    public List<StuClass> findClassBySchool(HttpServletResponse response, School school)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return stuClassService.findAllClassBySchool(school);
    }
}
