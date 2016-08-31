/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.dao;

import com.securityofspring.springwebproject.model.Student;
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
 * @author admin
 */

public class StudentDAOImpl implements StudentDAO{
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }



    @Override
    public void update(Student student) {
        
        // update
        String sql = "UPDATE student SET  name=?, surname=?, "
                    + "studid=?, class_id=?, password= ? WHERE id=?";
        
        jdbcTemplate.update(sql,student.getName(), student.getSurname(),
                student.getStudid(), student.getClassid()
              , student.getPassword(), student.getId());
    

        
    }

    @Override
    public void delete(int studentId) {
      String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql, studentId);

    }

    @Override
    public Student get(int studentId) {
     
        String sql = "SELECT * FROM student WHERE id=" + studentId;
    return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
 
        @Override
        public Student extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
                Student contact = new Student();
                contact.setId(rs.getInt("id"));
            contact.setName(rs.getString("name"));
            contact.setSurname(rs.getString("surname"));
            contact.setStudid(rs.getString("studid"));
            contact.setClassid(rs.getInt("class_id"));
            contact.setPassword(rs.getString("password"));
            contact.setEnabled(rs.getBoolean("enabled"));
                return contact;
            }
 
            return null;
        }
 
    });
 
        
    }
    
      @Override
    public Student get(String student) 
    {
        String sql = "SELECT * FROM student WHERE studid='"+student+"'";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
 
        @Override
        public Student extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
                Student contact = new Student();
                contact.setId(rs.getInt("id"));
            contact.setName(rs.getString("name"));
            contact.setSurname(rs.getString("surname"));
            contact.setStudid(rs.getString("studid"));
            contact.setClassid(rs.getInt("class_id"));
            contact.setPassword(rs.getString("password"));
            contact.setEnabled(rs.getBoolean("enabled"));
                return contact;
            }
 
            return null;
        }
 
    });
        
    }
    

    @Override
    public List<Student> list() {
    
        String sql = "SELECT * FROM student";
    List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {
 
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student aContact = new Student();
 
            aContact.setId(rs.getInt("id"));
            aContact.setName(rs.getString("name"));
            aContact.setSurname(rs.getString("surname"));
            aContact.setStudid(rs.getString("studid"));
            aContact.setClassid(rs.getInt("class_id"));
            aContact.setPassword(rs.getString("password"));
            aContact.setEnabled(rs.getBoolean("enabled"));
            return aContact;
        }

            
 
    });
 
    return listStudent;

        
    }

    @Override
    public void insert(Student student) {
              // insert
        String sql = "INSERT INTO student (id, name, surname, studid, class_id, password, enabled)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        jdbcTemplate.update(sql, student.getId(), student.getName(),
                            student.getSurname(), student.getStudid(),
                            student.getClassid(),
                            student.getPassword(),student.getEnabled());

    }
    
}
