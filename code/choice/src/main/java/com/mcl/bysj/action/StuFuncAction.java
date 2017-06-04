package com.mcl.bysj.action;

import com.mcl.bysj.dao.StuDao;
import com.mcl.bysj.entity.*;
import com.mcl.bysj.service.ScoreLimitService;
import com.mcl.bysj.service.StuFuncService;
import com.mcl.bysj.service.StuGradeService;
import com.mcl.bysj.service.TermService;
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
 * 学生相关操作
 * Created by 明春霖 on 17/5/20.
 */
@Controller
public class StuFuncAction
{
    @Autowired
    private TermService termService;

    @Autowired
    private StuDao stuDao;

    @Autowired
    private StuFuncService stuFuncService;

    @Autowired
    private ScoreLimitService scoreLimitService;

    @Autowired
    private StuGradeService stuGradeService;

    @RequestMapping(value = "/requiredLesson", method = RequestMethod.GET)
    public String showRequiredLesson(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(2))
            {
                String userId = request.getSession().getAttribute("userId").toString();
                Student newStu = new Student();
                newStu.setStuId(userId);
                Student student = stuDao.findStudent(newStu);
                if (null != student && null != student.getGradeYear() && !Helper.isEmpty(student.getStuSchool()))
                {
                    List<Term> termList = termService.findAllTerms();
                    if (null != termList)
                    {
                        LessonInfo lessonInfo = new LessonInfo();
                        lessonInfo.setGradeYear(student.getGradeYear());
                        Term term = termList.get(termList.size() - 1);
                        lessonInfo.setTerm(term.getTerm());
                        lessonInfo.setSchool(student.getStuSchool());
                        List<LessonInfo> lessonList= stuFuncService.findRequiredLesson(lessonInfo);
                        if (null != lessonList)
                        {
                            LessonChoice myLessonChoice = new LessonChoice();
                            myLessonChoice.setStuId(userId);
                            myLessonChoice.setTerm(term.getTerm());
                            List<LessonChoice> myList = stuFuncService.findAllLessonChoice(myLessonChoice);
                            if (null != myList)
                            {
                                List<String> requiredLessonIdList = new ArrayList<>(0);
                                for (LessonChoice lc : myList)
                                {
                                    if (!"选修".equals(lc.getLessonType()))
                                    {
                                        requiredLessonIdList.add(lc.getLessonId());
                                    }
                                }
                                if (0 < requiredLessonIdList.size())
                                {
                                    for (int i = 0; i < lessonList.size(); i++)
                                    {
                                        if (requiredLessonIdList.contains(lessonList.get(i).getLessonId()))
                                        {
                                            lessonList.remove(i);
                                            i = i - 1;
                                        }
                                    }
                                }
                            }
                            model.addAttribute("lessonList",lessonList);
                        }
                    }
                }

                model.addAttribute("userId",userId);
                return "stu/stu";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/chooseLesson", method = RequestMethod.POST)
    @ResponseBody
    public int chooseLesson(HttpServletResponse response, LessonChoice lessonChoice)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != lessonChoice)
        {
            List<String> myList = new ArrayList<>(1);
            myList.add(lessonChoice.getStuId());
            myList.add(lessonChoice.getLessonId());
            myList.add(lessonChoice.getLessonName());
            myList.add(lessonChoice.getLessonType());
            myList.add(lessonChoice.getLessonTime());
            myList.add(lessonChoice.getLessonWeeks());
            myList.add(lessonChoice.getClassroom());
            myList.add(lessonChoice.getTeacherId());
            myList.add(lessonChoice.getTeacherName());
            if (!Helper.checkEmpty(myList) && null != lessonChoice.getLessonScore()
                    && null != lessonChoice.getTerm())
            {
                LessonInfo lessonInfo = stuFuncService.findLessonById(lessonChoice.getLessonId());
                if (null != lessonInfo)
                {
                    LessonChoice stuLessonChoice = new LessonChoice();
                    stuLessonChoice.setLessonId(lessonChoice.getLessonId());
                    stuLessonChoice.setStuId(lessonChoice.getStuId());
                    if (null == stuFuncService.findLessonChoiceById(stuLessonChoice))
                    {
                        if (lessonInfo.getLessonChosedStu() < lessonInfo.getLessonOptionalStu())
                        {
                            LessonChoice newLessonChoice = new LessonChoice();
                            newLessonChoice.setStuId(lessonChoice.getStuId());
                            newLessonChoice.setTerm(lessonChoice.getTerm());
                            List<LessonChoice> lessonChoiceList = stuFuncService.findAllLessonChoice(newLessonChoice);
                            Double scoreAmount = 0.0;
                            if (null != lessonChoiceList)
                            {
                                for (LessonChoice lc : lessonChoiceList)
                                {
                                    scoreAmount += lc.getLessonScore();
                                }
                            }
                            scoreAmount += lessonChoice.getLessonScore();
                            List<ScoreLimit> scoreLimitList = scoreLimitService.findAllScoreLimits();
                            if (null != scoreLimitList && null != scoreLimitList.get(0)
                                    && null != scoreLimitList.get(0).getScoreLimit())
                            {
                                if (scoreAmount <= scoreLimitList.get(0).getScoreLimit())
                                {
                                    LessonInfo myLesson = new LessonInfo();
                                    myLesson.setLessonId(lessonChoice.getLessonId());
                                    myLesson.setLessonChosedStu(lessonInfo.getLessonChosedStu() + 1);
                                    stuFuncService.updateChoseStu(myLesson);
                                    return stuFuncService.addLessonChoice(lessonChoice);
                                }
                                else
                                {
                                    return -20000;  //已达选课学分上限
                                }
                            }
                        }
                        else
                        {
                            return -10000; //选课人数已满
                        }
                    }
                    else
                    {
                        return -100;  //已经选择了该课程
                    }
                }
                else
                {
                    return -200; //该课程不存在
                }
            }
        }
        return 0;  //选课失败
    }

    @RequestMapping(value = "/choseLesson", method = RequestMethod.GET)
    public String showChoseLesson(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(2))
            {
                String userId = request.getSession().getAttribute("userId").toString();
                List<Term> termList = termService.findAllTerms();
                if (null != termList)
                {
                    Term term = termList.get(termList.size() - 1);
                    LessonChoice myLessonChoice = new LessonChoice();
                    myLessonChoice.setStuId(userId);
                    myLessonChoice.setTerm(term.getTerm());
                    List<LessonChoice> lessonList = stuFuncService.findAllLessonChoice(myLessonChoice);
                    if (null != lessonList)
                    {
                        model.addAttribute("lessonList",lessonList);
                        Double scoreAmount = 0.0;
                        for (LessonChoice lc : lessonList)
                        {
                            scoreAmount += lc.getLessonScore();
                        }
                        model.addAttribute("scoreAmount",Math.round(scoreAmount * 10) / 10D);
                    }
                }

                model.addAttribute("userId",userId);

                model.addAttribute("scoreLimit",scoreLimitService.findAllScoreLimits().get(0).getScoreLimit());
                return "stu/choseLesson";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/cancelLesson", method = RequestMethod.POST)
    @ResponseBody
    public int removeLesson(HttpServletResponse response, LessonChoice lessonChoice)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != lessonChoice && !Helper.isEmpty(lessonChoice.getLessonId())
                && !Helper.isEmpty(lessonChoice.getStuId()))
        {
            if (1 == stuFuncService.deleteLessonChoice(lessonChoice))
            {
                LessonInfo lessonInfo = stuFuncService.findLessonById(lessonChoice.getLessonId());
                if (null != lessonInfo)
                {
                    LessonInfo newLessonInfo = new LessonInfo();
                    newLessonInfo.setLessonId(lessonInfo.getLessonId());
                    newLessonInfo.setLessonChosedStu(lessonInfo.getLessonChosedStu() - 1);
                    stuFuncService.updateChoseStu(newLessonInfo);
                }
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping(value = "/recentGrade", method = RequestMethod.GET)
    public String showRecentGrade(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(2))
            {
                String userId = request.getSession().getAttribute("userId").toString();
                List<Term> termList = termService.findAllTerms();
                if (null != termList && termList.size() > 0)
                {
                    Term term = termList.get(termList.size() - 2);
                    StuGrade stuGrade = new StuGrade();
                    stuGrade.setStuId(userId);
                    stuGrade.setTerm(term.getTerm());
                    List<StuGrade> list = stuGradeService.findStuGradeByTerm(stuGrade);
                    model.addAttribute("list",list);
                }

                model.addAttribute("userId",userId);

                return "stu/stuGrade";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/allGrade", method = RequestMethod.GET)
    public String showAllGrade(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(2))
            {
                String userId = request.getSession().getAttribute("userId").toString();
                List<StuGrade> list = stuGradeService.findStuGradeByStuId(userId);
                model.addAttribute("userId",userId);
                model.addAttribute("list",list);
                return "stu/stuGrade";
            }
        }
        return Helper.checkUserType((Integer)request.getSession().getAttribute("userType"));
    }
}
