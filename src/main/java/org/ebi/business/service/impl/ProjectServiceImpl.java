package org.ebi.business.service.impl;

import org.dozer.Mapper;
import org.ebi.business.dto.ProjectDTO;
import org.ebi.business.dto.ProjectDetailsDTO;
import org.ebi.business.service.ProjectService;
import org.ebi.entity.ProjectEntity;
import org.ebi.entity.TaxonomyEntity;
import org.ebi.repository.ProjectRepository;
import org.ebi.rest.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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
    public ProjectDetailsDTO findOne(String projectId) {
        ProjectEntity projectEntity = projectRepository.findOne(projectId);
        if(null == projectEntity){
            throw new BadRequestException(-1, String.format("Not found with ID %s",projectId));
        }
        return mapper.map(projectEntity, ProjectDetailsDTO.class);
    }

    @Override
    public List<ProjectDTO> find(Integer taxonomyId,  String title, String sourceType, String studyType, String evaCenterName, String centerName) {
        ProjectEntity filter = new ProjectEntity();
        filter.setTitle(title);
        filter.setSourceType(sourceType);
        filter.setStudyType(studyType);
        filter.setEvaCenterName(evaCenterName);
        filter.setCenterName(centerName);
        if(null != taxonomyId) {
            TaxonomyEntity taxonomyEntity = new TaxonomyEntity();
            taxonomyEntity.setTaxonomyId(taxonomyId);
            filter.setTaxonomy(taxonomyEntity);
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        Example example = Example.of(filter, matcher);
        List<ProjectEntity> list = projectRepository.findAll(example);
        List<ProjectDTO> dtos = new ArrayList<>();
       list.stream().forEach(p-> {
           ProjectDTO projectDTO = mapper.map(p, ProjectDTO.class);
           projectDTO.setTaxonomyId(p.getTaxonomy().getTaxonomyId());
           dtos.add(projectDTO);
       });
        return dtos;
    }

    @Override
    public String save(ProjectDetailsDTO dto) {
        return projectRepository.save(mapper.map(dto, ProjectEntity.class)).getProjectId();
    }

    @Override
    public void delete(String projectId) {
        findOne(projectId);
        projectRepository.delete(projectId);
    }

    @Override
    public ProjectDetailsDTO update(String projectId, ProjectDetailsDTO dto) {
        findOne(projectId);
        ProjectEntity projectEntity = mapper.map(dto, ProjectEntity.class);
        projectEntity.setProjectId(projectId);
        ProjectEntity entity = projectRepository.save(projectEntity);
        return mapper.map(entity, ProjectDetailsDTO.class);
    }
}
