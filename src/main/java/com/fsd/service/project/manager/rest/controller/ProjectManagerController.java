package com.fsd.service.project.manager.rest.controller;

import com.fsd.service.project.manager.entity.Project;
import com.fsd.service.project.manager.service.ProjectManagerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/project/manager")
public class ProjectManagerController {

    @Autowired
    private ProjectManagerService service;

    @ApiOperation(value = "Fetches all projects from the database.", response = Project.class)
    @GetMapping("/getAllProjects")
    public ResponseEntity<List<Project>> getAllProjects() throws Exception {
        log.info("ProjectManagerController >> getAllProjects >> ");
        List<Project> projects = service.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch project by the provided id from the database.", response = Project.class)
    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<Optional<Project>> getProjectById(@PathVariable("id") Long id) throws Exception {
        log.info("ProjectManagerController >> getProjectById >> "+id);
        Optional<Project> project = service.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @ApiOperation(value = "Add the new project into the database and return new project.", response = Project.class)
    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestBody Project project) throws Exception {
        log.info("ProjectManagerController >> addProject >> {}", project);
        Project newProject = service.saveProject(project);
        log.info("Project Added. New Id {} and project {}", newProject.getProjectId(), newProject);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update the new project into the database and return updated project", response = Project.class)
    @PutMapping("/updateProject")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) throws Exception {
        log.info("ProjectManagerController >> updateProject >> {}", project);
        Project updatedProject = service.saveProject(project);
        log.info("Project Updated. New Id {} and project {}", updatedProject.getProjectId(), updatedProject);
        return new ResponseEntity<>(updatedProject, HttpStatus.CREATED);
    }
}