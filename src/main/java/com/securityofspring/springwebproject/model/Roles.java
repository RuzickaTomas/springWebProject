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
public class Roles {
   private String username;
   private String user_role;

    public Roles() {
    }

    public Roles(String username, String user_role) {
        this.username = username;
        this.user_role = user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_role() {
        return user_role;
    }

    public String getUsername() {
        return username;
    }
   
   
    
}
