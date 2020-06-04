package com.shreerama.mblade.controller;

import java.util.List;

import com.blade.ioc.annotation.Inject;
import com.blade.mvc.RouteContext;
import com.blade.mvc.annotation.DeleteRoute;
import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.annotation.PutRoute;
import com.blade.mvc.annotation.Route;
import com.blade.mvc.http.HttpMethod;
import com.blade.mvc.http.Response;
import com.shreerama.mblade.model.Project;
import com.shreerama.mblade.model.User;
import com.shreerama.mblade.service.ProjectService;

@Path
public class RouteController {

    @Inject
    private ProjectService pService;

    @GetRoute("/")
    public String index(Response r) {
        return "index.html";
    }

    @GetRoute("/getProjects")
    @JSON
    public List<Project> listProjects() {
        return pService.getAllProjects();
    }

    @PostRoute("/save")
    public void saveUser(@Param String username) {
        System.out.println("username:" + username);
    }

    @PutRoute("/changeProjectName")
    @JSON
    public String changePName(@Param String pcode, @Param String pname) {
        Project p = pService.getProject(pcode);
        String msg = "";
        if (p != null) {
            if (pService.changeName(pcode, pname))
                msg = "project name successfully updated.";
            else
                msg = "project name failed update.";
        } else
            msg = "project with code " + pcode + " doesnt exist.";

        return msg;
    }

    @DeleteRoute("/delete/:uid")
    public void updateUser(@PathParam Integer uid) {
        System.out.println("delete user:" + uid);
    }

    @Route(value = "/html", method = HttpMethod.GET)
    public void printHtml(RouteContext ctx) {
        ctx.html("<h1>I Love Blade!</h1>");
    }

    @Route(value = "/text", method = HttpMethod.GET)
    public void printText(RouteContext ctx) {
        ctx.html("I Love Blade!");
    }

    @GetRoute("/users/json")
    @JSON
    public User printJSON() {
        return new User("biezhi", 18);
    }
}