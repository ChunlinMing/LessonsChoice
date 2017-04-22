package com.mcl.bysj.vo;

/**
 * 更改课程类型实体类
 * Created by mingchunlin on 17/4/21.
 */
public class ChangeLessonType
{
    /**
     * 要更改的课程类型
     */
    private String lessonTypeBefore;

    /**
     * 更改为此课程类型
     */
    private String lessonTypeAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getLessonTypeBefore()
    {
        return lessonTypeBefore;
    }

    public void setLessonTypeBefore(String lessonTypeBefore)
    {
        this.lessonTypeBefore = lessonTypeBefore;
    }

    public String getLessonTypeAfter()
    {
        return lessonTypeAfter;
    }

    public void setLessonTypeAfter(String lessonTypeAfter)
    {
        this.lessonTypeAfter = lessonTypeAfter;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }
}
