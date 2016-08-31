/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.model;

/**
 *
 * @author Tomáš
 */
public class Works {

    private Integer id;
    private String name;
    private String studid;

    public Works() {
    }
       
    public Works(Integer id, String name, String studid) {
        this.id = id;
        this.name = name;
        this.studid = studid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudid() {
        return studid;
    }
    
    
    
    
}
