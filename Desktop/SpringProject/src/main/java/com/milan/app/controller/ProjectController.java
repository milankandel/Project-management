/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.controller;

import com.milan.app.core.controller.CrudController;
import com.milan.app.entity.ProjectEmployee;
import com.milan.app.entity.Projects;
import com.milan.app.repository.EmployeeRepository;
import com.milan.app.repository.ProjectRepository;
import com.milan.app.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController extends CrudController<Projects> {

    @Autowired
    private EmployeeRepository employeeRepository;
  
     
  
  
  @Autowired
 private ProjectEmployee pemployeerepository;
    
   
   @Autowired
  private ProjectRepository projectRepository;
 
    
    @Autowired
    private StatusRepository statusRepository;

     
    
    public ProjectController() {
        pageTitle = "Project";
        viewPath = "project";
    }

    @Override
    public String index(Model model) {
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        return super.index(model);
    }

}
