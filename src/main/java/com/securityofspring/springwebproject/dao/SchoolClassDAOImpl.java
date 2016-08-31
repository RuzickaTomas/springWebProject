/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.SchoolClass;
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
public class SchoolClassDAOImpl implements SchoolClassDAO{
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void update(SchoolClass sc) {
        // update
        String sql = "UPDATE class SET title=? WHERE id=?";
        jdbcTemplate.update(sql,sc.getTitle(),sc.getId());
    
    }

    @Override
    public void delete(int clsid) {
            String sql = "DELETE FROM class WHERE id=?";
            jdbcTemplate.update(sql, clsid);
    }

    @Override
    public SchoolClass get(int studentId) {
           String sql = "SELECT * FROM class WHERE id=" + studentId;
    return jdbcTemplate.query(sql, new ResultSetExtractor<SchoolClass>() {
 
        @Override
        public SchoolClass extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
                SchoolClass sc = new SchoolClass();
                sc.setId(rs.getInt("id"));
                sc.setTitle(rs.getString("title"));
          
                return sc;
            }
 
            return null;
        }
 
    });
 
    }

    @Override
    public List<SchoolClass> list() {
         String sql = "SELECT * FROM class";
    List<SchoolClass> listStudent = jdbcTemplate.query(sql, new RowMapper<SchoolClass>() {
 
        @Override
        public SchoolClass mapRow(ResultSet rs, int rowNum) throws SQLException {
            SchoolClass sc = new SchoolClass();
 
            sc.setId(rs.getInt("id"));
            sc.setTitle(rs.getString("title"));
          
            return sc;
        }

            
 
    });
 
    return listStudent;
    }

    @Override
    public void insert(SchoolClass sc) {
                    // insert
        String sql = "INSERT INTO class (id, title)"
                    + " VALUES (?, ?)";
       
        jdbcTemplate.update(sql, sc.getId(), sc.getTitle());
    }
    
}
