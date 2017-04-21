package com.mcl.bysj.action;

import com.mcl.bysj.entity.Term;
import com.mcl.bysj.service.TermService;
import com.mcl.bysj.utils.Helper;
import com.mcl.bysj.vo.ChangeTerm;
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
 * 管理员对学期进行操作
 * Created by mingchunlin on 17/4/20.
 */
@Controller
public class TermAction {
    @Autowired
    private TermService termService;

    @RequestMapping(value = "/addTerm", method = RequestMethod.GET)
    public String addTermPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Term> termList = termService.findAllTerms();
                model.addAttribute("termList",termList);
                return "manager/addTerm";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/addTerm", method = RequestMethod.POST)
    @ResponseBody
    public int addTerm(HttpServletResponse response, Term term)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (null != term)
        {
            return termService.insertTerm(term);
        }
        return 0;
    }

    @RequestMapping(value = "/changeTerm", method = RequestMethod.GET)
    public String changeTermPage(HttpServletRequest request, Model model)
    {
        if (request.getSession().getAttribute("userType") != null)
        {
            if (request.getSession().getAttribute("userType").equals(0))
            {
                List<Term> termList = termService.findAllTerms();
                model.addAttribute("termList",termList);
                return "manager/changeTerm";
            }
        }
        return Helper.checkUserType((Integer) request.getSession().getAttribute("userType"));
    }

    @RequestMapping(value = "/changeTerm", method = RequestMethod.POST)
    @ResponseBody
    public int changeTerm(HttpServletResponse response, ChangeTerm changeTerm)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        if(null != changeTerm && null != changeTerm.getTermAfter() && null != changeTerm.getTermBefore())
        {
            return termService.updateTerm(changeTerm);
        }
        return 0;
    }
}
