package com.milan.app.core.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




public abstract class CrudController<T> extends 
        SiteController{
    
    
         @Autowired
        protected JpaRepository<T,Integer> repository;
    
    protected String viewPath;
      
    /**
     *
     */
 
    
    @GetMapping()
    public String index(Model model) {
       
        model.addAttribute("records", repository.findAll());
         
        return viewPath+"/index";
    }
       
    
    
    
    
    

}
