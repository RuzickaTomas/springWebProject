/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.Works;
import java.util.List;

/**
 *
 * @author Tomáš
 */
public interface WorksDAO {
 
        
    public void update(Works works);
     
    public void delete(int worksId);
     
    public Works get(int worksId);
    
    public List<Works> list();
     
    public List<Works> userList(String name);
    
    public List<Works> adminList();

    public void insert(Works work);
}
