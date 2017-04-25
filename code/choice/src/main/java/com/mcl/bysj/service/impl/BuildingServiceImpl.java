package com.mcl.bysj.service.impl;

import com.mcl.bysj.dao.BuildingDao;
import com.mcl.bysj.entity.Building;
import com.mcl.bysj.service.BuildingService;
import com.mcl.bysj.vo.ChangeBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作学院名称逻辑实现
 * Created by mingchunlin on 17/4/22.
 */
@Service
public class BuildingServiceImpl implements BuildingService
{
    @Autowired
    private BuildingDao buildingDao;

    /**
     * 查找所有教学楼
     * @return 教学楼集合
     */
    public List<Building> findAllBuildings()
    {
        return buildingDao.findAllBuildings();
    }

    /**
     * 添加教学楼
     * @param building 教学楼
     * @return 成功1，失败0，已存在-100
     */
    public int insertBuilding(Building building)
    {
        if (null == buildingDao.findBuilding(building))
        {
            return buildingDao.insertBuilding(building);
        }
        return -100;
    }

    /**
     * 更改教学楼名称
     * @param changeBuilding 更改教学楼名称实体对象
     * @return 成功1，失败0
     */
    public int updateBuilding(ChangeBuilding changeBuilding)
    {
        Building building = new Building();
        building.setBuilding(changeBuilding.getBuildingAfter());
        if (null == buildingDao.findBuilding(building))
        {
            return buildingDao.updateBuilding(changeBuilding);
        }
        return -100;
    }

    /**
     * 删除教学楼
     * @param building 教学楼
     * @return 成功1，失败0
     */
    public int deleteBuilding(Building building)
    {
        return buildingDao.deleteBuilding(building);
    }
}
