package com.shreerama.mblade.service;

import java.util.List;

import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.shreerama.mblade.dao.ProjectDao;
import com.shreerama.mblade.model.Project;
@Bean
public class ProjectServiceImpl implements ProjectService {
    
    @Inject
    private ProjectDao pDao;
    
    @Override
    public List<Project> getAllProjects() {
        
        return pDao.getAllProjects();
    }
    @Override
    public boolean changeName(String pcode,String pname){
        return pDao.changeName(pcode,pname);
    }

    @Override
    public Project getProject(String pcode) {
        return pDao.getProject(pcode);
    }

    
    
}