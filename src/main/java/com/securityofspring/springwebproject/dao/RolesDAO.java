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
 * @author Tomáš
 */
public interface RolesDAO {
      public void update(Student role);
     
    public void delete(int roles);
     
    public Student get(int Roles);
     
    public List<Roles> list();

    public void insert(Student contact);
}
