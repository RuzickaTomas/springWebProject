/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.Roles;
import com.securityofspring.springwebproject.model.Student;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tomáš
 */
public class RolesDAOImpl implements RolesDAO{
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) 
    {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    
    @Override
    public void update(Student role) {
         String sql = "UPDATE roles SET  username=? WHERE id=?";
        
        jdbcTemplate.update(sql, role.getStudid(), role.getId());
    }

    @Override
    public void delete(int roles) {
        String sql = "DELETE FROM roles WHERE id=?";
        jdbcTemplate.update(sql, roles);   
    }

    @Override
    public Student get(int Roles) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Roles> list() {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  void insert(Student contact) {
      String sql = "INSERT INTO roles(username, user_role) VALUES (?, 'USER')";
      jdbcTemplate.update(sql, contact.getStudid());
    }
    
}
