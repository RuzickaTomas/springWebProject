/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject;

import com.securityofspring.springwebproject.cls.UploadManager;
import com.securityofspring.springwebproject.model.Works;
import com.securityofspring.springwebproject.dao.WorksDAO;
import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tomáš
 */
@Controller
public class UploadController {
    
    @Autowired
    private WorksDAO worksDao;

    public static String dir = System.getProperty("user.home")+"\\Dokumenty\\";
   
    @RequestMapping(value="/send.htm", method = RequestMethod.POST)
    public ModelAndView send(@ModelAttribute("uploadForm") UploadManager upManager,
                             @AuthenticationPrincipal Principal principal) 
    throws Exception
    {   
        
  
        List<MultipartFile> uploadFiles = upManager.getFiles();
        List<String> fileNames = new ArrayList<>();
        
        if ((null != uploadFiles) && (uploadFiles.size() > 0)) {
            for (MultipartFile multipartFile : uploadFiles) {

                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile
                            .transferTo(new File(dir + fileName));
                    fileNames.add(fileName);
                    Works w = new Works();
                    w.setName(fileName);  
                    w.setStudid(principal.getName());
                    worksDao.insert(w);
                    }
                }
            }
        ModelAndView mav = new ModelAndView("redirect:/user.htm");
        return mav;
    }
    
    @RequestMapping(value="/adminSend.htm", method = RequestMethod.POST)
    public ModelAndView sendAdmin(@ModelAttribute("uploadForm") UploadManager upManager,
                             @AuthenticationPrincipal Principal principal) throws Exception
    {   
        
  
        List<MultipartFile> uploadFiles = upManager.getFiles();
        List<String> fileNames = new ArrayList<>();
        
        if ((null != uploadFiles) && (uploadFiles.size() > 0)) {
            for (MultipartFile multipartFile : uploadFiles) {

                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile
                            .transferTo(new File(dir + fileName));
                    fileNames.add(fileName);
                    Works w = new Works();
                    w.setName(fileName);  
                    w.setStudid(principal.getName());
                    worksDao.insert(w);
                    }
                }
            }
        ModelAndView mav = new ModelAndView("redirect:/admin.htm");
        return mav;
    }
    
    @RequestMapping(value="/deleteWork.htm", method = RequestMethod.GET)
    public ModelAndView deleteWork(HttpServletRequest request,
          @AuthenticationPrincipal Principal principal)
    {
    int contactId = Integer.parseInt(request.getParameter("id"));
    String file = worksDao.get(contactId).getName();
    if (worksDao.get(contactId).getStudid().equals(principal.getName())) {
    new File(dir+file).delete(); 
    worksDao.delete(contactId);
    return new ModelAndView("redirect:/user.htm");   
    }
    return new ModelAndView("redirect:/user.htm");     
    }
    
    @RequestMapping(value="/deleteAdminWork.htm", method = RequestMethod.GET)
    public ModelAndView deleteAdminWork(HttpServletRequest request)
    {
    int contactId = Integer.parseInt(request.getParameter("id"));
    String file = worksDao.get(contactId).getName();
    new File(dir+file).delete();
    
    worksDao.delete(contactId);
    return new ModelAndView("redirect:/admin.htm");     
    }
    
    
}
