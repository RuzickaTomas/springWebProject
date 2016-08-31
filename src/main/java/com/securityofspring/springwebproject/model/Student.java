/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.model;

/**
 *
 * @author admin
 */
public class Student {
            private Integer id;
            private String  name;
            private String  surname;
            private String  studid;
            private Integer classid;
            private String  password;
            private Boolean enabled;

    public Student() {
    }

    public Student(Integer id, String name, String surname, String studid, 
                   Integer classid, String password,
                   Boolean enabled) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.studid = studid;
        this.classid = classid;
        this.password = password;
        this.enabled = enabled;
    }

            
            
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }


    public void setClassid(Integer classid) {
        this.classid = classid;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getClassid() {
        return classid;
    }

    public String getStudid() {
        return studid;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }
            
    
    
    
}
