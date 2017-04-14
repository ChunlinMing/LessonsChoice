package com.mcl.bysj.entity;

import java.io.Serializable;

/**
 * 课程类型实体类
 * Created by mingchunlin on 17/4/10.
 */
public class LessonType implements Serializable
{
    /**
     * 课程类型名称
     */
    private String lessonTypeName;

    public String getLessonTypeName()
    {
        return lessonTypeName;
    }

    public void setLessonTypeName(String lessonTypeName)
    {
        this.lessonTypeName = lessonTypeName;
    }
}
