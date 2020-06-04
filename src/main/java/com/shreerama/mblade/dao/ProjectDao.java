package com.shreerama.mblade.dao;

import java.util.List;

import com.shreerama.mblade.model.Project;

public interface ProjectDao {
    public boolean changeName(String pcode, String pname);
    public List<Project> getAllProjects();
	public Project getProject(String pcode);
}
