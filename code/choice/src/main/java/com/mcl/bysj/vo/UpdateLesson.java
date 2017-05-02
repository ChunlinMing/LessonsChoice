package com.mcl.bysj.vo;

import java.io.Serializable;

/**
 * 更改课程实体类
 * Created by mingchunlin on 17/4/28.
 */
public class UpdateLesson implements Serializable
{
    /**
     * 要更改的课程id
     */
    private String lessonIdBefore;

    /**
     * 更改为此课程id
     */
    private String lessonIdAfter;

    /**
     * 更改为此课程名
     */
    private String lessonNameAfter;

    /**
     * 更改为此教室
     */
    private String classroomAfter;

    /**
     * 更改为此上课时间
     */
    private String lessonTimeAfter;

    /**
     * 更改为此上课时段
     */
    private String lessonWeeksAfter;

    /**
     * 更改为此可选课人数
     */
    private Integer lessonOptionalStuAfter;

    /**
     * 更改为此课程类型
     */
    private String lessonTypeAfter;

    /**
     * 更改为此上课学期
     */
    private Integer termAfter;

    /**
     * 更改为此学分
     */
    private Double lessonScoreAfter;

    /**
     * 更改为此可选课年级
     */
    private Integer gradeYearAfter;

    /**
     * 更改为此可选课学院
     */
    private String schoolAfter;

    public String getLessonIdBefore()
    {
        return lessonIdBefore;
    }

    public void setLessonIdBefore(String lessonIdBefore)
    {
        this.lessonIdBefore = lessonIdBefore;
    }

    public String getLessonIdAfter()
    {
        return lessonIdAfter;
    }

    public void setLessonIdAfter(String lessonIdAfter)
    {
        this.lessonIdAfter = lessonIdAfter;
    }

    public String getLessonNameAfter()
    {
        return lessonNameAfter;
    }

    public void setLessonNameAfter(String lessonNameAfter)
    {
        this.lessonNameAfter = lessonNameAfter;
    }

    public String getClassroomAfter()
    {
        return classroomAfter;
    }

    public void setClassroomAfter(String classroomAfter)
    {
        this.classroomAfter = classroomAfter;
    }

    public String getLessonTimeAfter()
    {
        return lessonTimeAfter;
    }

    public void setLessonTimeAfter(String lessonTimeAfter)
    {
        this.lessonTimeAfter = lessonTimeAfter;
    }

    public String getLessonWeeksAfter()
    {
        return lessonWeeksAfter;
    }

    public void setLessonWeeksAfter(String lessonWeeksAfter)
    {
        this.lessonWeeksAfter = lessonWeeksAfter;
    }

    public Integer getLessonOptionalStuAfter()
    {
        return lessonOptionalStuAfter;
    }

    public void setLessonOptionalStuAfter(Integer lessonOptionalStuAfter)
    {
        this.lessonOptionalStuAfter = lessonOptionalStuAfter;
    }

    public String getLessonTypeAfter()
    {
        return lessonTypeAfter;
    }

    public void setLessonTypeAfter(String lessonTypeAfter)
    {
        this.lessonTypeAfter = lessonTypeAfter;
    }

    public Integer getTermAfter()
    {
        return termAfter;
    }

    public void setTermAfter(Integer termAfter)
    {
        this.termAfter = termAfter;
    }

    public Double getLessonScoreAfter()
    {
        return lessonScoreAfter;
    }

    public void setLessonScoreAfter(Double lessonScoreAfter)
    {
        this.lessonScoreAfter = lessonScoreAfter;
    }

    public Integer getGradeYearAfter()
    {
        return gradeYearAfter;
    }

    public void setGradeYearAfter(Integer gradeYearAfter)
    {
        this.gradeYearAfter = gradeYearAfter;
    }

    public String getSchoolAfter()
    {
        return schoolAfter;
    }

    public void setSchoolAfter(String schoolAfter)
    {
        this.schoolAfter = schoolAfter;
    }
}
