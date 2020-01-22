package com.milan.app.core.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class CrudController<T, Id> extends
        SiteController {

    @Autowired
    protected JpaRepository<T, Id> repository;

    protected String viewPath;

    /**
     *
     */
    @GetMapping
    public String index(Model model) {

        model.addAttribute("records", repository.findAll());

        return viewPath + "/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        return viewPath + "/create";
    }
    
    @PostMapping()
    public String save(T model) {
        repository.save(model);
        return "redirect:/"+uri;
    }
    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id")Id id,Model model){
          model.addAttribute("record", repository.findById(id).get());
          return viewPath+ "/edit";
    }
    
    
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Id id) {
        repository.deleteById(id);
        return "redirect:/" + uri + "?success";
    }
    

    

}
