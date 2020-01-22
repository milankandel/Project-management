/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.project.controller;

import com.milan.app.core.controller.CrudController;
import com.milan.app.entity.Employees;
import com.milan.app.entity.ProjectEmployee;
import com.milan.app.entity.Projects;
import com.milan.app.repository.EmployeeRepository;
import com.milan.app.repository.ProjectEmployeeRepository;
import com.milan.app.repository.ProjectRepository;
import com.milan.app.repository.StatusRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping(value = "/project")
public class ProjectController extends CrudController<Projects, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectEmployeeRepository pemployeerepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StatusRepository statusRepository;

    public ProjectController() {
        activeMenu = "master";
        pageTitle = "Project";
        viewPath = "project";
        uri = "project";
    }

    @Override
    public String index(Model model) {
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());
        model.addAttribute("project", projectRepository.findAll());
        return super.index(model);
    }

    @Override
    public String create(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projectstatus", statusRepository.findAll());
        model.addAttribute("project", projectRepository.findAll());

        return super.create(model);
    }

    @GetMapping(value = "/detail/{id}")
    //@ResponseBody
    public String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("pageTitle", "Project Detail");
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projectemployee", pemployeerepository.findByProjectId(id));
        model.addAttribute("projects", projectRepository.findById(id).get());
        
       return "project/detail";


    }

    @GetMapping(value = "/employees")
    @ResponseBody
    public List<ProjectEmployee> findAll() {
        return pemployeerepository.findAll();
    }
   
    
    
   @GetMapping(value = "/employees/add")
    @ResponseBody
    @Transactional
    public String addEmployee(@RequestParam("projectId") int id,
            @RequestParam("employeeList") List<Employees> employees) 
    {
       Projects project =repository.findById(id).get();  
       List<ProjectEmployee> projectEmployees = new ArrayList<>();
        for (Employees employee : employees) {
            ProjectEmployee pe = new ProjectEmployee();
            pe.setEmployee(employee);
            pe.setProject(project);
           projectEmployees.add(pe);    
            
        }

        pemployeerepository.saveAll(projectEmployees);
    
        return "success"; 

}  
    
   
}
