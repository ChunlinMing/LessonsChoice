package com.mcl.bysj.vo;

/**
 * 更改教学楼实体类
 * Created by mingchunlin on 17/4/22.
 */
public class ChangeBuilding
{
    /**
     * 要更改的教学楼名称
     */
    private String buildingBefore;

    /**
     * 更改为此名称
     */
    private String buildingAfter;

    /**
     * 0为删除，1为更改
     */
    private int flag;

    public String getBuildingBefore()
    {
        return buildingBefore;
    }

    public void setBuildingBefore(String buildingBefore)
    {
        this.buildingBefore = buildingBefore;
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
