package org.ebi.business.service.impl;

import org.dozer.Mapper;
import org.ebi.business.dto.ProjectDTO;
import org.ebi.business.dto.ProjectDetailsDTO;
import org.ebi.business.service.ProjectService;
import org.ebi.entity.ProjectEntity;
import org.ebi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private Mapper mapper;
    @Override
    public List<ProjectDTO> findAll() {
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        List<ProjectDTO> dtos = new ArrayList<ProjectDTO>();
        mapper.map(projectEntities, dtos);
        return dtos;
    }

    @Override
    public List<ProjectDTO> findByTaxomony(Integer taxomonyId) {
        List<ProjectEntity> projectEntities = projectRepository.findByTaxonomyTaxonomyId(taxomonyId);
        List<ProjectDTO> dtos = new ArrayList<>();
        mapper.map(projectEntities, dtos);
        return dtos;
    }

    @Override
    public List<ProjectDTO> findByStudyType(String studyType) {
        List<ProjectEntity> projectEntities = projectRepository.findByStudyType(studyType);
        List<ProjectDTO> dtos = new ArrayList<>();
        mapper.map(projectEntities, dtos);
        return dtos;
    }

    @Override
    public ProjectDetailsDTO findOne(String projectId) {
        return mapper.map(projectRepository.findOne(projectId), ProjectDetailsDTO.class);
    }
}
