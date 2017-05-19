package com.mcl.bysj.action;

import com.github.pagehelper.Page;
import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.Teacher;
import com.mcl.bysj.service.SchoolService;
import com.mcl.bysj.service.TeacherService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员操作教师信息
 * Created by mingchunlin on 17/4/24.
 */
@Controller
public class TeacherAction
{
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacherPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/addTeacher";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    @ResponseBody
    public int addTeacher(HttpServletResponse response, Teacher teacher)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != teacher)
        {
            List<String> list = new ArrayList<>(5);
            list.add(teacher.getTeacherId());
            list.add(teacher.getTeacherName());
            list.add(teacher.getTeacherGender());
            list.add(teacher.getTeacherSchool());
            list.add(teacher.getTeacherEmail());
            if (!Helper.checkEmpty(list))
            {
                return teacherService.insertTeacher(teacher);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/changeTeacher", method = RequestMethod.GET)
    public String changeTeacherPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                return "manager/changeTeacher";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeTeacher", method = RequestMethod.POST)
    @ResponseBody
    public int changeTeacher(HttpServletResponse response, ChangeTeacher changeTeacher)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeTeacher && !Helper.isEmpty(changeTeacher.getTeacherIdBefore()))
        {
            if (0 == changeTeacher.getFlag())
            {
                Teacher teacher = new Teacher();
                teacher.setTeacherId(changeTeacher.getTeacherIdBefore());
                return teacherService.deleteTeacher(teacher);
            }
            else if (1 == changeTeacher.getFlag())
            {
                List<String> list = new ArrayList<>(5);
                list.add(changeTeacher.getTeacherIdAfter());
                list.add(changeTeacher.getTeacherNameAfter());
                list.add(changeTeacher.getTeacherGenderAfter());
                list.add(changeTeacher.getTeacherSchoolAfter());
                list.add(changeTeacher.getTeacherEmailAfter());
                if (!Helper.checkEmpty(list))
                {
                    return teacherService.updateTeacher(changeTeacher);
                }
            }
        }
        return 0;
    }

    @RequestMapping(value = "/showTeachers", method = RequestMethod.GET)
    public String findAllTeacher(HttpServletRequest request, Model model,
                                 @RequestParam(value = "page", defaultValue = "1") int page)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Teacher> teacherList = teacherService.findAllTeacher(page);
                int pages = ((Page)teacherList).getPages();
                model.addAttribute("teacherList",teacherList);
                model.addAttribute("pages",pages == 0 ? 1 : pages);
                model.addAttribute("current_page",page);
                return "manager/showTeachers";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/findTeacherBySchool", method = RequestMethod.POST)
    @ResponseBody
    public List<Teacher> findTeacherBySchool(HttpServletResponse response, School school)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return teacherService.findAllTeacherBySchool(school);
    }

    @RequestMapping(value = "/findTeacherById", method = RequestMethod.POST)
    @ResponseBody
    public Teacher findTeacherById(HttpServletResponse response, Teacher teacher)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return teacherService.findTeacher(teacher);
    }
}
