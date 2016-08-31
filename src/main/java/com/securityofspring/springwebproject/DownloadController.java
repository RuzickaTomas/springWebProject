/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tomáš
 */

package com.securityofspring.springwebproject;



import com.securityofspring.springwebproject.dao.WorksDAO;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Tomáš
 */
@Controller
public class DownloadController {
    @Autowired
    private WorksDAO worksDao;
    
    
    @RequestMapping(value="/download.htm", method = RequestMethod.GET)
    public ModelAndView download(HttpServletRequest request) throws MalformedURLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = worksDao.get(id).getName();
     String path = System.getProperty("user.home")+"\\Dokumenty\\"+name;
    //"http://student.vsmie.cz/~ruzit3ap/Davka1_xhtml/page.htm"; 
     URL u = Paths.get(path).toUri().toURL();
     // URL u = new URL(path);
     BufferedInputStream bis = new BufferedInputStream(u.openStream());
     FileOutputStream fos = new FileOutputStream(System.getProperty("user.home")+"\\Downloads\\"+name);

     byte[] buffer = new byte[1024];
     int count = 0;
     while((count = bis.read(buffer,0,1024)) != -1) 
     {
      fos.write(buffer,0,count);
     }

     fos.close();
     bis.close();
   
    
     return new ModelAndView("redirect:/admin.htm");
     
    }
    
    @RequestMapping(value="/downloadInd.htm", method = RequestMethod.GET)
    public ModelAndView downloadInd(HttpServletRequest request) throws MalformedURLException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = worksDao.get(id).getName();
     String path = System.getProperty("user.home")+"\\Dokumenty\\"+name;
    //"http://student.vsmie.cz/~ruzit3ap/Davka1_xhtml/page.htm"; 
     URL u = Paths.get(path).toUri().toURL();
     // URL u = new URL(path);
     BufferedInputStream bis = new BufferedInputStream(u.openStream());
     FileOutputStream fos = new FileOutputStream(System.getProperty("user.home")+"\\Downloads\\"+name);

     byte[] buffer = new byte[1024];
     int count = 0;
     while((count = bis.read(buffer,0,1024)) != -1) 
     {
      fos.write(buffer,0,count);
     }

     fos.close();
     bis.close();
   
    
     return new ModelAndView("redirect:/index.htm");
     
    }
    

}


