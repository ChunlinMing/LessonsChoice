package com.mcl.bysj.action;

import com.mcl.bysj.entity.Building;
import com.mcl.bysj.entity.Classroom;
import com.mcl.bysj.service.BuildingService;
import com.mcl.bysj.service.ClassroomService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeClassroom;
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
 * 管理员操作教室信息
 * Created by mingchunlin on 17/4/23.
 */
@Controller
public class ClassroomAction
{
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "/addClassroom", method = RequestMethod.GET)
    public String addClassroomPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Building> buildingList = buildingService.findAllBuildings();
                model.addAttribute("buildingList",buildingList);
                return "manager/addClassroom";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "addClassroom", method = RequestMethod.POST)
    @ResponseBody
    public int addClassroom(HttpServletResponse response, Classroom classroom)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != classroom && !Helper.isEmpty(classroom.getClassroom())
                && !Helper.isEmpty(classroom.getBuilding()))
        {
            return classroomService.insertClassroom(classroom);
        }
        return 0;
    }

    @RequestMapping(value = "changeClassroom", method = RequestMethod.GET)
    public String changeClassroomPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Building> buildingList = buildingService.findAllBuildings();
                model.addAttribute("buildingList",buildingList);
                return "manager/changeClassroom";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeClassroom", method = RequestMethod.POST)
    @ResponseBody
    public int changeClassroom(HttpServletResponse response, ChangeClassroom changeClassroom)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != changeClassroom && !Helper.isEmpty(changeClassroom.getClassroomBefore()))
        {
            if (!Helper.isEmpty(changeClassroom.getClassroomAfter()) && !Helper.isEmpty(changeClassroom.getBuildingAfter())
                    && changeClassroom.getFlag() == 1)
            {
                return classroomService.updateClassroom(changeClassroom);
            }
            else if (Helper.isEmpty(changeClassroom.getClassroomAfter()) && Helper.isEmpty(changeClassroom.getBuildingAfter())
                    && changeClassroom.getFlag() == 0)
            {
                Classroom classroom = new Classroom();
                classroom.setClassroom(changeClassroom.getClassroomBefore());
                return classroomService.deleteClassroom(classroom);
            }
        }
        return 0;
    }

    @RequestMapping(value = "findClassroomByBuilding", method = RequestMethod.POST)
    @ResponseBody
    public List<Classroom> findClassroomByBuilding(HttpServletResponse response, Building building)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return classroomService.findAllClassroomByBuilding(building);
    }

    @RequestMapping(value = "findBuildingByClassroom", method = RequestMethod.POST)
    @ResponseBody
    public String findBuildingByClassroom(HttpServletResponse response, Classroom classroom)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return classroomService.findClassroom(classroom).getBuilding();
    }
}
