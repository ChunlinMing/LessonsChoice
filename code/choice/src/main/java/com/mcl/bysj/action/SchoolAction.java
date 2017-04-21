package com.mcl.bysj.action;

import com.mcl.bysj.entity.School;
import com.mcl.bysj.service.SchoolService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeSchool;
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
 * 管理员操作学院
 * Created by mingchunlin on 17/4/21.
 */
@Controller
public class SchoolAction
{
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/addSchool", method = RequestMethod.GET)
    public String addSchoolPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/addSchool";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addSchool", method = RequestMethod.POST)
    @ResponseBody
    public int addSchool(HttpServletResponse response, School school)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != school && !Helper.isEmpty(school.getSchool()))
        {
            return schoolService.insertSchool(school);
        }
        return 0;
    }

    @RequestMapping(value = "/changeSchool", method = RequestMethod.GET)
    public String changeSchoolPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/changeSchool";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeSchool", method = RequestMethod.POST)
    @ResponseBody
    public int changeSchool(HttpServletResponse response, ChangeSchool changeSchool)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeSchool && !Helper.isEmpty(changeSchool.getSchoolBefore()))
        {
            if (!Helper.isEmpty(changeSchool.getSchoolAfter()) && changeSchool.getFlag() == 1)
            {
                return schoolService.updateSchool(changeSchool);
            }
            else if (Helper.isEmpty(changeSchool.getSchoolAfter()) && changeSchool.getFlag() == 0)
            {
                School school = new School();
                school.setSchool(changeSchool.getSchoolBefore());
                return schoolService.deleteSchool(school);
            }
        }
        return 0;
    }
}
