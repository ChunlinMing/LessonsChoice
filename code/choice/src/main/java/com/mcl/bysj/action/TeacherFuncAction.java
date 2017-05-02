package com.mcl.bysj.action;

import com.mcl.bysj.entity.*;
import com.mcl.bysj.service.*;
import com.mcl.bysj.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 教师操作控制器
 * Created by mingchunlin on 17/4/28.
 */
@Controller
public class TeacherFuncAction
{
    @Autowired
    TeacherService teacherService;

    @Autowired
    TeacherFuncService teacherFuncService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    ClassroomService classroomService;

    @Autowired
    LessonTypeService lessonTypeService;

    @Autowired
    TermService termService;

    @Autowired
    GradeYearService gradeYearService;

    @Autowired
    SchoolService schoolService;

    @RequestMapping(value = "/showStudent", method = RequestMethod.POST)
    public String showStudent(HttpServletRequest request, Model model)
    {
        model.addAttribute("userId",request.getSession().getAttribute("userId"));
        return "";
    }

    @RequestMapping(value = "/addLesson", method = RequestMethod.GET)
    public String addLessonPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(1))
            {
                String id = request.getSession().getAttribute("userId").toString();
                Teacher teacher = new Teacher();
                teacher.setTeacherId(id);
                Teacher teacherResult = teacherService.findTeacher(teacher);
                List<Building> buildingList = buildingService.findAllBuildings();
                List<LessonType> lessonTypeList = lessonTypeService.findAllLessonTypes();
                List<Term> terms = termService.findAllTerms();
                List<GradeYear> gradeYears = gradeYearService.findAllGradeYears();
                List<School> schoolList = schoolService.findAllSchools();

                List<Term> termList = new ArrayList<>(1);
                List<GradeYear> gradeYearList = new ArrayList<>(1);
                for (int i = 0; i < terms.size(); i++)
                {
                    termList.add(terms.get(terms.size() - i -1));
                }
                for (int i = 0; i < gradeYears.size(); i++)
                {
                    gradeYearList.add(gradeYears.get(gradeYears.size() - i - 1));
                }
                terms = null;
                gradeYears = null;

                model.addAttribute("userId",id);
                model.addAttribute("teacherName",teacherResult.getTeacherName());
                model.addAttribute("buildingList",buildingList);
                model.addAttribute("lessonTypeList",lessonTypeList);
                model.addAttribute("termList",termList);
                model.addAttribute("gradeYearList",gradeYearList);
                model.addAttribute("schoolList",schoolList);
                return "teacher/addLesson";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    @ResponseBody
    public int addLesson(HttpServletResponse response, LessonInfo lessonInfo)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != lessonInfo)
        {
            List<String> list = new ArrayList<>(9);
            list.add(lessonInfo.getLessonId());
            list.add(lessonInfo.getLessonName());
            list.add(lessonInfo.getClassroom());
            list.add(lessonInfo.getLessonTime());
            list.add(lessonInfo.getLessonWeeks());
            list.add(lessonInfo.getLessonType());
            list.add(lessonInfo.getSchool());
            list.add(lessonInfo.getTeacherId());
            list.add(lessonInfo.getTeacherName());
            if (!Helper.checkEmpty(list) && null != lessonInfo.getGradeYear() && null != lessonInfo.getLessonOptionalStu()
                    && null != lessonInfo.getLessonScore() && null != lessonInfo.getTerm())
            {
                lessonInfo.setLessonChosedStu(0);
                return teacherFuncService.insertLesson(lessonInfo);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/changeLesson", method = RequestMethod.POST)
    @ResponseBody
    public int changeLesson(HttpServletResponse response)
    {
        return 0;
    }

    @RequestMapping(value = "/deleteLesson", method = RequestMethod.POST)
    @ResponseBody
    public int deleteLesson(HttpServletResponse response)
    {
        return 0;
    }
}
