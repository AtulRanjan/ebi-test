package org.ebi.repository;

import org.ebi.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, String>{
    List<ProjectEntity> findByTaxonomyTaxonomyId(Integer taxomonyId);
    List<ProjectEntity> findByStudyType(String studyType);
}
