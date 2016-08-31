/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.securityofspring.springwebproject.cls;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Tomáš
 */
public class UploadManager {
    
    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
    
    
    
}
