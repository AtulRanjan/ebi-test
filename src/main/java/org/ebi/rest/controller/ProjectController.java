package org.ebi.rest.controller;

import org.ebi.business.dto.ProjectDTO;
import org.ebi.business.dto.ProjectDetailsDTO;
import org.ebi.business.service.ProjectService;
import org.ebi.entity.ProjectEntity;
import org.ebi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> find(
            @RequestParam(required = false) Integer taxonomyId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String sourceType,
            @RequestParam(required = false) String studyType,
            @RequestParam(required = false) String evaCenterName,
            @RequestParam(required = false) String centerName)
    {
        return ResponseEntity.ok(projectService.find(taxonomyId, title, sourceType, studyType, evaCenterName, centerName));
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDetailsDTO> findOne(@PathVariable String projectId){
        return ResponseEntity.ok(projectService.findOne(projectId));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProjectDetailsDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(dto));
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDetailsDTO> findOne(@PathVariable String projectId, @RequestBody ProjectDetailsDTO dto){
        return ResponseEntity.ok(projectService.update(projectId, dto));
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity delete(@PathVariable String projectId){
        projectService.delete(projectId);
        return ResponseEntity.ok(null);
    }

}
