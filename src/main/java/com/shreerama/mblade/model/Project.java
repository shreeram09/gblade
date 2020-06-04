package com.shreerama.mblade.model;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;

@Table(name="project",pk="p_id")
public class Project extends Model {
    
    @Column(name="p_name")
    private String p_name;
    
    @Column(name="code")
    private String code;

    @Column(name="p_id")
    private Integer p_id;

    public Project(){}
    public Project(String pName, String code, Integer pId) {
        this.p_name = pName;
        this.code = code;
        this.p_id = pId;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    
}