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
public class SchoolClass {
    private Integer id;
    private String title;

    public SchoolClass() {
    }

    public SchoolClass(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    
    
}
