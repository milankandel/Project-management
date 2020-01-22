/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.milan.app.repository;

import com.milan.app.entity.ProjectEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ACER
 */
@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee,Integer>{
    List<ProjectEmployee> findByProjectId(int id);

}
