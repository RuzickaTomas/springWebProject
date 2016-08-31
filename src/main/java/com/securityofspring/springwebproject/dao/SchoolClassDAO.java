/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.SchoolClass;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public interface SchoolClassDAO {
 
    public void update(SchoolClass sch);
     
    public void delete(int classId);
     
    public SchoolClass get(int classId);
    
    public List<SchoolClass> list();

    public void insert(SchoolClass sc);
    
}
