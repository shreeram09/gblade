package com.shreerama.mblade.service;

import java.util.List;

import com.shreerama.mblade.model.Project;

public interface ProjectService {
    public boolean changeName(String pcode, String pname);
    public List<Project> getAllProjects();
    public Project getProject(String pcode);
}