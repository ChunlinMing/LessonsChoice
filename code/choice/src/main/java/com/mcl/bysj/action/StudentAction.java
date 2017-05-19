package com.mcl.bysj.action;

import com.github.pagehelper.Page;
import com.mcl.bysj.entity.GradeYear;
import com.mcl.bysj.entity.School;
import com.mcl.bysj.entity.StuClass;
import com.mcl.bysj.entity.Student;
import com.mcl.bysj.service.GradeYearService;
import com.mcl.bysj.service.SchoolService;
import com.mcl.bysj.service.StudentService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeStu;
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
 * 管理员操作学生信息
 * Created by mingchunlin on 17/4/24.
 */
@Controller
public class StudentAction
{
    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private GradeYearService gradeYearService;

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudentPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                List<GradeYear> gradeYearList = gradeYearService.findAllGradeYears();
                model.addAttribute("gradeYearList",gradeYearList);
                return "manager/addStudent";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public int addStudent(HttpServletResponse response, Student student)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != student)
        {
            List<String> list = new ArrayList<>(6);
            list.add(student.getStuId());
            list.add(student.getStuName());
            list.add(student.getStuGender());
            list.add(student.getStuSchool());
            list.add(student.getStuClass());
            list.add(student.getStuEmail());
            if (!Helper.checkEmpty(list) && null != student.getGradeYear())
            {
                return studentService.insertStudent(student);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/changeStudent", method = RequestMethod.GET)
    public String changeStudentPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<School> schoolList = schoolService.findAllSchools();
                model.addAttribute("schoolList",schoolList);
                List<GradeYear> gradeYearList = gradeYearService.findAllGradeYears();
                model.addAttribute("gradeYearList",gradeYearList);
                return "manager/changeStudent";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeStudent", method = RequestMethod.POST)
    @ResponseBody
    public int changeStudent(HttpServletResponse response, ChangeStu changeStu)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeStu && !Helper.isEmpty(changeStu.getStuIdBefore()))
        {
            if (0 == changeStu.getFlag())
            {
                Student student = new Student();
                student.setStuId(changeStu.getStuIdBefore());
                return studentService.deleteStudent(student);
            }
            else if (1 == changeStu.getFlag())
            {
                List<String> list = new ArrayList<>(6);
                list.add(changeStu.getStuIdAfter());
                list.add(changeStu.getStuNameAfter());
                list.add(changeStu.getStuGenderAfter());
                list.add(changeStu.getStuSchoolAfter());
                list.add(changeStu.getStuClassAfter());
                list.add(changeStu.getStuEmailAfter());
                if (!Helper.checkEmpty(list) && null != changeStu.getGradeYearAfter())
                {
                    return studentService.updateStudent(changeStu);
                }
            }
        }
        return 0;
    }

    @RequestMapping(value = "showStudents", method = RequestMethod.GET)
    public String findAllStudent(HttpServletRequest request, Model model,
                                 @RequestParam(value = "page", defaultValue = "1") int page)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Student> studentList = studentService.findAllStudent(page);
                int pages = ((Page)studentList).getPages();
                model.addAttribute("studentList",studentList);
                model.addAttribute("pages",pages == 0 ? 1 : pages);
                model.addAttribute("current_page",page);
                return "manager/showStudents";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/findStudentByStuClass", method = RequestMethod.POST)
    @ResponseBody
    public List<Student> findStudentByStuClass(HttpServletResponse response, StuClass stuClass)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.findAllStudentByStuClass(stuClass);
    }

    @RequestMapping(value = "/findStudentById", method = RequestMethod.POST)
    @ResponseBody
    public Student findStudentById(HttpServletResponse response, Student student)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return studentService.findStudent(student);
    }
}
