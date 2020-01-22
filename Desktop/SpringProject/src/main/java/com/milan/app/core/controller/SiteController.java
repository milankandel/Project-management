/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.core.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author ACER
 */
public abstract class SiteController {
    
    protected String activeMenu;
    protected String pageTitle;
    protected String uri;
    
    @ModelAttribute(value="activeMenu")
    public String getActiveMenu(){
        return activeMenu;
    
}
    @ModelAttribute(value = "pageTitle")
    public String getpageTitle(){
       return pageTitle;  
    }
    @ModelAttribute(value = "uri")
    public String geturi(){
        return uri;
    }
}