package org.ebi.business.service;

import org.ebi.business.dto.ProjectDetailsDTO;
import org.ebi.business.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDetailsDTO findOne(String projectId);
    List<ProjectDTO> find(Integer toxonomyId,  String title, String sourceType, String studyType, String evaCenterName, String centerName);
    String save(ProjectDetailsDTO dto);
    void delete(String projectId);
    ProjectDetailsDTO update(String projectId, ProjectDetailsDTO dto);
}
