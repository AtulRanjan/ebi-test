package org.ebi.business.service;

import org.ebi.business.dto.ProjectDetailsDTO;
import org.ebi.business.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> findAll();
    List<ProjectDTO> findByTaxomony(Integer taxomonyId);
    List<ProjectDTO> findByStudyType(String studyType);
    ProjectDetailsDTO findOne(String projectId);

}
