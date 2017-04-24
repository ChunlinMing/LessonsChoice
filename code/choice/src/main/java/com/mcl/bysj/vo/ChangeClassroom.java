package com.mcl.bysj.vo;

/**
 * 更改教室信息实体类
 * Created by mingchunlin on 17/4/23.
 */
public class ChangeClassroom
{
    /**
     * 要更改的教室
     */
    private String classroomBefore;

    /**
     * 更改为此教室
     */
    private String classroomAfter;

    /**
     * 更改为此教学楼
     */
    private String buildingAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getClassroomBefore()
    {
        return classroomBefore;
    }

    public void setClassroomBefore(String classroomBefore)
    {
        this.classroomBefore = classroomBefore;
    }

    public String getClassroomAfter()
    {
        return classroomAfter;
    }

    public void setClassroomAfter(String classroomAfter)
    {
        this.classroomAfter = classroomAfter;
    }

    public String getBuildingAfter()
    {
        return buildingAfter;
    }

    public void setBuildingAfter(String buildingAfter)
    {
        this.buildingAfter = buildingAfter;
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
