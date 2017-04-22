package com.mcl.bysj.dao;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.vo.ChangeBuilding;

import java.util.List;

/**
 * 教学楼操作dao接口
 * Created by mingchunlin on 17/4/22.
 */
public interface BuildingDao
{
    /**
     * 查找指定的教学楼
     * @param building 教学楼
     * @return 查找结果
     */
    String findBuilding(Building building);

    /**
     * 查找所有教学楼
     * @return 教学楼集合
     */
    List<Building> findAllBuildings();

    /**
     * 添加教学楼
     * @param building 教学楼
     * @return 成功1，失败0
     */
    int insertBuilding(Building building);

    /**
     * 更改教学楼名称
     * @param changeBuilding 更改教学楼名称实体对象
     * @return 成功1，失败0
     */
    int updateBuilding(ChangeBuilding changeBuilding);

    /**
     * 删除教学楼
     * @param building 教学楼
     * @return 成功1，失败0
     */
    int deleteBuilding(Building building);
}
