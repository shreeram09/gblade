package com.shreerama.mblade.dao;

import java.util.List;

import com.blade.ioc.annotation.Bean;
import com.shreerama.mblade.model.Project;

import io.github.biezhi.anima.Anima;
@Bean
public class ProjectDaoImpl implements ProjectDao {

    
    @Override
    public boolean changeName(String pcode, String pname) {
        boolean result =false;
        result = Anima.atomic(() -> {
           Anima.update().from(Project.class).set("p_name", pname).where("code", pcode).execute();

        }).catchException(e -> e.printStackTrace()).isRollback();
        return !result;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = Anima.select().from(Project.class).all();
        return projects;
    }

    @Override
    public Project getProject(String pcode) {
        return Anima.select().from(Project.class).where(Project::getCode).eq(pcode).one();
    }
    
}