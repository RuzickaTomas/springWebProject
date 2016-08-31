/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.Works;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tomáš
 */
public class WorksDAOImpl implements WorksDAO{

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }
    
    @Override
    public void update(Works works) {
       String sql = "UPDATE works SET name=? WHERE studid=?";
       jdbcTemplate.update(sql, works.getName(), works.getStudid());
    }

    @Override
    public void delete(int worksId) {      
        String sql = "DELETE FROM works WHERE id=?";
        jdbcTemplate.update(sql, worksId);
    }

    @Override
    public Works get(int worksId) {
        String sql = "SELECT * FROM works WHERE id="+worksId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Works>() {
 
        @Override
        public Works extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
                Works work = new Works();
                work.setId(rs.getInt("id"));
                work.setName(rs.getString("name"));
                work.setStudid(rs.getString("studid"));
            return work;
            }
 
            return null;
        }
 
    });
    }
    @Override
    public List<Works> list() {
  
         String sql = "SELECT * FROM works";
         List<Works> listWorks = jdbcTemplate.query(sql, new RowMapper<Works>() {
 
        @Override
        public Works mapRow(ResultSet rs, int rowNum) throws SQLException {
            Works w = new Works();
 
            w.setId(rs.getInt("id"));
            w.setName(rs.getString("name"));  
            w.setStudid(rs.getString("studid"));
 
            return w;
        } 
    });
       return listWorks;
    }

    @Override
    public List<Works> userList(String name) {
  
         String sql = "SELECT * FROM works"
                    + " JOIN roles ON works.studid = roles.username"
                    + " WHERE works.studid='"+name+"'";
         List<Works> listWorks = jdbcTemplate.query(sql, new RowMapper<Works>() {
 
        @Override
        public Works mapRow(ResultSet rs, int rowNum) throws SQLException {
            Works w = new Works();
 
            w.setId(rs.getInt("id"));
            w.setName(rs.getString("name"));  
            w.setStudid(rs.getString("studid"));
 
            return w;
        } 
    });
       return listWorks;
    }
    
       @Override
    public List<Works> adminList() 
    {
                String sql = "SELECT * FROM works"
                           + " JOIN roles ON works.studid=roles.username "
                           + " WHERE roles.user_role='ADMIN'";
         List<Works> listWorks = jdbcTemplate.query(sql, new RowMapper<Works>() {
 
        @Override
        public Works mapRow(ResultSet rs, int rowNum) throws SQLException {
            Works w = new Works();
 
            w.setId(rs.getInt("id"));
            w.setName(rs.getString("name"));  
            w.setStudid(rs.getString("studid"));
 
            return w;
        } 
    });
       return listWorks;
    }

    @Override
    public void insert(Works work) {
       
        String sql = "INSERT INTO works (name, studid)"
                    + " VALUES (?, ?)";
        
        jdbcTemplate.update(sql, work.getName(),
                                 work.getStudid());
        
    }

 
    
}
