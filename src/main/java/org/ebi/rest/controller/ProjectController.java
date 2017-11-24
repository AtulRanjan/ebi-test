package org.ebi.rest.controller;

import org.ebi.entity.ProjectEntity;
import org.ebi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;
    @GetMapping
    public ResponseEntity<List<ProjectEntity>> getAll(){
        return ResponseEntity.ok(projectRepository.findAll());
    }
}
