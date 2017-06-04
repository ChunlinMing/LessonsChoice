package com.mcl.bysj.action;

import com.mcl.bysj.entity.*;
import com.mcl.bysj.service.*;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.UpdateLesson;
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
    private TeacherService teacherService;

    @Autowired
    private TeacherFuncService teacherFuncService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private LessonTypeService lessonTypeService;

    @Autowired
    private TermService termService;

    @Autowired
    private GradeYearService gradeYearService;

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private StuGradeService stuGradeService;

    @Autowired
    private StudentService studentService;

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
    public int changeLesson(HttpServletResponse response, UpdateLesson updateLesson)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != updateLesson)
        {
            List<String> list = new ArrayList<>(8);
            list.add(updateLesson.getLessonIdBefore());
            list.add(updateLesson.getLessonIdAfter());
            list.add(updateLesson.getLessonNameAfter());
            list.add(updateLesson.getClassroomAfter());
            list.add(updateLesson.getLessonTimeAfter());
            list.add(updateLesson.getLessonWeeksAfter());
            list.add(updateLesson.getLessonTypeAfter());
            list.add(updateLesson.getSchoolAfter());
            if (!Helper.checkEmpty(list) && null != updateLesson.getGradeYearAfter() &&
                    null != updateLesson.getLessonOptionalStuAfter() && null != updateLesson.getLessonScoreAfter())
            {
                return teacherFuncService.updateLesson(updateLesson);
            }
        }
        return 0;
    }

    @RequestMapping(value = "/deleteLesson", method = RequestMethod.POST)
    @ResponseBody
    public int deleteLesson(HttpServletResponse response, LessonInfo lessonInfo)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != lessonInfo && !Helper.isEmpty(lessonInfo.getLessonId()))
        {
            return teacherFuncService.deleteLesson(lessonInfo.getLessonId());
        }
        return 0;
    }

    @RequestMapping(value = "/stuGrade", method = RequestMethod.GET)
    public String getStuGrade(HttpServletRequest request, Model model, String lessonId)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(1))
            {
                String id = request.getSession().getAttribute("userId").toString();
                model.addAttribute("userId",id);
                LessonInfo lessonInfo = teacherFuncService.findLessonById(lessonId);
                if (null != lessonInfo)
                {
                    model.addAttribute("lessonInfo", lessonInfo);
                    List<LessonChoice> lessonChoiceList = stuGradeService.findLessonChoiceByLessonId(lessonId);
                    if(null != lessonChoiceList && lessonChoiceList.size() > 0)  //有学生选择该课程
                    {
                        List<Term> termList = termService.findAllTerms();
                        if (null != termList)
                        {
                            Term term = termList.get(termList.size() - 2); //取第二大的学期
                            List<StuGrade> stuGradeList = stuGradeService.findStuGradeByLessonId(lessonId);

                            if (null != stuGradeList)
                            {
                                model.addAttribute("stuGradeList",stuGradeList);
                            }
                            if (term.getTerm() > lessonChoiceList.get(0).getTerm())
                            {
                                return "teacher/stuGradePage";
                            }
                            else if ((int)term.getTerm() == lessonChoiceList.get(0).getTerm())  //查询选择该课程的学生，用于录入成绩
                            {
                                List<Student> stuList = new ArrayList<>(0);
                                Student student = new Student();
                                for (LessonChoice lc : lessonChoiceList)
                                {
                                    student.setStuId(lc.getStuId());
                                    stuList.add(studentService.findStudent(student));
                                }
                                model.addAttribute("stuList",stuList);
                                return "teacher/addStuGrade";
                            }
                        }
                    }
                    List<Student> stuList = new ArrayList<>(0);
                    Student student = new Student();
                    for (LessonChoice lc : lessonChoiceList)
                    {
                        student.setStuId(lc.getStuId());
                        stuList.add(studentService.findStudent(student));
                    }
                    model.addAttribute("stuList",stuList);
                    return "teacher/showStu";
                }
                return "redirect:/teacher";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addStuGrade", method = RequestMethod.POST)
    @ResponseBody
    public int addStuGrade(HttpServletResponse response, StuGrade stuGrade)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != stuGrade && null != stuGrade.getTerm() && null != stuGrade.getStuGrade())
        {
            List<String> list = new ArrayList<>(1);
            list.add(stuGrade.getLessonId());
            list.add(stuGrade.getExamType());
            list.add(stuGrade.getLessonName());
            list.add(stuGrade.getLessonType());
            list.add(stuGrade.getStuClass());
            list.add(stuGrade.getStuId());
            list.add(stuGrade.getStuName());
            if (!Helper.checkEmpty(list))
            {
                return stuGradeService.addStuGrade(stuGrade);
            }
        }
        return 0;
    }
}
