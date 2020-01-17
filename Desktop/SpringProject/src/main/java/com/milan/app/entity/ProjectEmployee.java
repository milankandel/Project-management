/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.entity;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "project_employee")
public class ProjectEmployee  {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "project_id")
    private Integer projectId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private int employeeId;

    public ProjectEmployee() {
    }

    public ProjectEmployee(Integer projectId) {
        this.projectId = projectId;
    }

    public ProjectEmployee(Integer projectId, int employeeId) {
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
    
}
