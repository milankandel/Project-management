/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.controller;
import com.milan.app.core.controller.CrudController;
import com.milan.app.entity.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 *
 * @author ACER
 */
@Controller
@RequestMapping(value = "/employee")

public class EmployeeController extends 
        CrudController<Employees,Integer>{
    
    public EmployeeController(){
        
    activeMenu="master";
    pageTitle="Employee";
    viewPath="/employee";
}
}