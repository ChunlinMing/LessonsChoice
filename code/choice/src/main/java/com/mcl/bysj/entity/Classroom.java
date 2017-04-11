package com.mcl.bysj.entity;

/**
 * 教室实体类
 * Created by mingchunlin on 17/4/10.
 */
public class Classroom
{
    /**
     * 教室
     */
    private String classroom;

    /**
     *  教室所在教学楼
     */
    private String building;

    public String getClassroom()
    {
        return classroom;
    }

    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    public String getBuilding()
    {
        return building;
    }

    public void setBuilding(String building)
    {
        this.building = building;
    }
}
