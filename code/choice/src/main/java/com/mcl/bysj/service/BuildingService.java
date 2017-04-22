package com.mcl.bysj.service;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.vo.ChangeBuilding;

import java.util.List;

/**
 * 操作学院名称逻辑接口
 * Created by mingchunlin on 17/4/22.
 */
public interface BuildingService
{
    List<Building> findAllBuildings();

    int insertBuilding(Building building);

    int updateBuilding(ChangeBuilding changeBuilding);

    int deleteBuilding(Building building);
}
