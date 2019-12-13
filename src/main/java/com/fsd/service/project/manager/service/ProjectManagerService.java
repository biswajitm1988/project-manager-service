package com.fsd.service.project.manager.service;

import com.fsd.service.project.manager.entity.Project;
import com.fsd.service.project.manager.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProjectManagerService {

    @Autowired
    private ProjectRepository repository;

    public List<Project> getAllProjects() {
        log.info("Getting All Projects from Database");
        return repository.findAll();
    }

    public Project saveProject(Project project) {
        log.info("Saving the Project into Database");
        return repository.save(project);
    }

    public Optional<Project> getProjectById(Long id) {
        log.info("Getting the Project by Id from Database for {}",id);
        return repository.findById(id);
    }
}
