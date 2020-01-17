/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.controller;

import com.milan.app.core.controller.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author ACER
 */
@Controller
@RequestMapping(value = "/")

public class HomeController extends SiteController{
    
        public HomeController(){
          activeMenu="home";  
        }
    @GetMapping()
    public String index(Model model){
     model.addAttribute("page_title","Dashboard");
        return"index";
    }
    
    

    
}
