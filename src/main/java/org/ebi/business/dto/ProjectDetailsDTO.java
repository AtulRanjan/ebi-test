package org.ebi.business.dto;

import lombok.Data;
import org.ebi.entity.TaxonomyEntity;

@Data
public class ProjectDetailsDTO {
    private String projectId;
    private String title;
    private String description;
    private String sourceType;
    private String studyType;
    private String evaCenterName;
    private String centerName;
    private TaxonomyEntity taxonomy;
}
