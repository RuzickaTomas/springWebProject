/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.Roles;
import com.securityofspring.springwebproject.model.Student;
import java.util.List;



/**
 *
 * @author admin
 */
public interface StudentDAO {
   
    /**
     *
     * @param student
     */
    
    public void update(Student student);
     
    public void delete(int studentId);
     
    public Student get(int studentId);
    
    public Student get(String student);
     
    public List<Student> list();

    public void insert(Student contact);

    
}
