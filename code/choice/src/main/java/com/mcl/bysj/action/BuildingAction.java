package com.mcl.bysj.action;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.service.BuildingService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeBuilding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员管理教学楼控制器
 * Created by mingchunlin on 17/4/22.
 */
@Controller
public class BuildingAction
{
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
    public String addBuildingPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Building> buildingList = buildingService.findAllBuildings();
                model.addAttribute("buildingList",buildingList);
                return "manager/addBuilding";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addBuilding", method = RequestMethod.POST)
    @ResponseBody
    public int addBuilding(HttpServletResponse response, Building building)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != building && !Helper.isEmpty(building.getBuilding()))
        {
            return buildingService.insertBuilding(building);
        }
        return 0;
    }

    @RequestMapping(value = "/changeBuilding", method = RequestMethod.GET)
    public String changeBuildingPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Building> buildingList = buildingService.findAllBuildings();
                model.addAttribute("buildingList",buildingList);
                return "manager/changeBuilding";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeBuilding", method = RequestMethod.POST)
    @ResponseBody
    public int changeBuilding(HttpServletResponse response, ChangeBuilding changeBuilding)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeBuilding && !Helper.isEmpty(changeBuilding.getBuildingBefore()))
        {
            if (!Helper.isEmpty(changeBuilding.getBuildingAfter()) && changeBuilding.getFlag() == 1)
            {
                return buildingService.updateBuilding(changeBuilding);
            }
            else if (Helper.isEmpty(changeBuilding.getBuildingAfter()) && changeBuilding.getFlag() == 0)
            {
                Building building = new Building();
                building.setBuilding(changeBuilding.getBuildingBefore());
                return buildingService.deleteBuilding(building);
            }
        }
        return 0;
    }
}
