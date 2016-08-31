/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject;

import com.securityofspring.springwebproject.dao.StudentDAO;
import com.securityofspring.springwebproject.dao.WorksDAO;
import com.securityofspring.springwebproject.model.Student;
import com.securityofspring.springwebproject.model.Works;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
@Controller
public class WebController {
    @Autowired
    private WorksDAO worksDao;
    @Autowired
    private StudentDAO studentDAO;
   
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout)
    {           
                ModelAndView mav = new ModelAndView();
                
                if (error != null) {
			mav.addObject("error", "Invalid username or password!");
		}

		if (logout != null) {
			mav.addObject("msg", "You've been logged out successfully.");
		}
		mav.setViewName("login");

		return mav;
        
    }
    
    
     @RequestMapping(value = { "/", "/index.htm" }, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        List<Works> worksList = worksDao.adminList();
        mav.addObject("list", worksList);
        
        return mav;
    }
 

    
 @RequestMapping(value = "/user.htm", method = RequestMethod.GET)
    public ModelAndView user(@AuthenticationPrincipal Principal principal) {
        ModelAndView mav = new ModelAndView();
        List<Works> workList = worksDao.userList(principal.getName());
        Student student = studentDAO.get(principal.getName());
        mav.addObject("student", student);
        mav.addObject("workList", workList);
        mav.setViewName("user");
        return mav;
    }


 
    @RequestMapping(value = "/403Page.htm", method = RequestMethod.GET)
    public ModelAndView accessDenied(ModelAndView model, Principal principal) {
         
        if (principal != null) {
            model.addObject("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addObject("msg",
                            "You do not have permission to access this page!");
        }
        model.setViewName("403Page");
        return model;
    }
 
}
