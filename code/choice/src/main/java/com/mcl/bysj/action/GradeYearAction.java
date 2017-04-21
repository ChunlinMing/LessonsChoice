package com.mcl.bysj.action;

import com.mcl.bysj.entity.GradeYear;
import com.mcl.bysj.entity.Term;
import com.mcl.bysj.service.GradeYearService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeGradeYear;
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
 * 管理员对年级操作
 * Created by mingchunlin on 17/4/21.
 */
@Controller
public class GradeYearAction
{
    @Autowired
    GradeYearService gradeYearService;

    @RequestMapping(value = "/addGradeYear", method = RequestMethod.GET)
    public String addGradeYearPage(HttpServletRequest request)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                return "manager/addGradeYear";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addGradeYear", method = RequestMethod.POST)
    @ResponseBody
    public int addGradeYear(HttpServletResponse response, GradeYear gradeYear)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != gradeYear)
        {
            return gradeYearService.insertGradeYear(gradeYear);
        }
        return -1;
    }

    @RequestMapping(value = "/changeGradeYear", method = RequestMethod.GET)
    public String changeGradeYearPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<GradeYear> gradeYearList = gradeYearService.findAllGradeYears();
                model.addAttribute("gradeYearList",gradeYearList);
                return "manager/changeGradeYear";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeGradeYear", method = RequestMethod.POST)
    @ResponseBody
    public int changeGradeYear(HttpServletResponse response, ChangeGradeYear changeGradeYear)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeGradeYear && null != changeGradeYear.getGradeYearAfter() && null != changeGradeYear.getGradeYearBefore())
        {
            return gradeYearService.updateGradeYear(changeGradeYear);
        }
        return -1;
    }
}
