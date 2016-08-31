/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject;

import com.securityofspring.springwebproject.dao.RolesDAO;
import com.securityofspring.springwebproject.dao.SchoolClassDAO;
import com.securityofspring.springwebproject.dao.StudentDAO;
import com.securityofspring.springwebproject.dao.WorksDAO;
import com.securityofspring.springwebproject.model.SchoolClass;
import com.securityofspring.springwebproject.model.Student;
import com.securityofspring.springwebproject.model.Works;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
@Controller
public class WebFormController {
    @Autowired
    private WorksDAO worksDao; 
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private RolesDAO rolesDAO;
    @Autowired
    private SchoolClassDAO schoolClassDAO;
    
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

 
    @RequestMapping(value="/admin.htm", method = RequestMethod.GET)
    public ModelAndView listContact() throws IOException{
   
    ModelAndView model = new ModelAndView();
    List<Student> listContact = studentDAO.list();
    List<Works> worksList = worksDao.list();
    List<SchoolClass> tridaList = schoolClassDAO.list();
    
    model.addObject("listContact", listContact);
    model.addObject("listHref", worksList);
    model.addObject("listTrida", tridaList);
    
    String dir = UploadController.dir;
    URL u = Paths.get(dir).toUri().toURL();
    model.addObject("dir", u);
    model.setViewName("admin");
    
    return model;
}

    
    @RequestMapping(value = "/newContact.htm", method = RequestMethod.GET)
    public ModelAndView newContact() {
         ModelAndView model = new ModelAndView();
    Student newContact = new Student();
    model.addObject("contact", newContact);
    model.setViewName("AddContactForm");
    return model;
    }
    
     @RequestMapping(value = "/newClass.htm", method = RequestMethod.GET)
    public ModelAndView newClass() {
    ModelAndView model = new ModelAndView();
    SchoolClass newClass = new SchoolClass();
    model.addObject("s_class", newClass);
    model.setViewName("AddClassForm");
    return model;
    }
    
        @RequestMapping(value = "/insertContact.htm", method = RequestMethod.POST)
    public ModelAndView insertContact(@ModelAttribute Student contact) {
    studentDAO.insert(contact);
    rolesDAO.insert(contact);
    return new ModelAndView("redirect:/admin.htm");
    }
    
    @RequestMapping(value = "/insertClass.htm", method = RequestMethod.POST)
    public ModelAndView insertClass(@ModelAttribute SchoolClass s_class) {
    schoolClassDAO.insert(s_class);
    return new ModelAndView("redirect:/admin.htm");
    }
    
    @RequestMapping(value = "/saveContact.htm", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Student contact) {
    studentDAO.update(contact);
    rolesDAO.update(contact);
    return new ModelAndView("redirect:/admin.htm");
    }
    
   @RequestMapping(value = "/saveClass.htm", method = RequestMethod.POST)
    public ModelAndView saveClass(@ModelAttribute SchoolClass s_classEdit) {
    schoolClassDAO.update(s_classEdit);
    return new ModelAndView("redirect:/admin.htm");
    }
    
    
    @RequestMapping(value = "/deleteContact.htm", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
    int contactId = Integer.parseInt(request.getParameter("id"));
    studentDAO.delete(contactId);
    rolesDAO.delete(contactId);
    return new ModelAndView("redirect:/admin.htm");  
    }
    
    @RequestMapping(value = "/deleteClass.htm", method = RequestMethod.GET)
    public ModelAndView deleteClass(HttpServletRequest request) {
    int contactId = Integer.parseInt(request.getParameter("id"));
    schoolClassDAO.delete(contactId);
    return new ModelAndView("redirect:/admin.htm");  
    }
    
    @RequestMapping(value = "/editContact.htm", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
    int contactId = Integer.parseInt(request.getParameter("id"));
    Student contact = studentDAO.get(contactId);
    ModelAndView model = new ModelAndView("ContactForm");
    model.addObject("contactEdit", contact);
 
    return model;
    }

    @RequestMapping(value = "/editClass.htm", method = RequestMethod.GET)
      public ModelAndView editClass(HttpServletRequest request) {
    int contactId = Integer.parseInt(request.getParameter("id"));
    SchoolClass cls = schoolClassDAO.get(contactId);
    ModelAndView model = new ModelAndView("ClassForm");
    model.addObject("s_classEdit", cls);
 
    return model;
    }




}
