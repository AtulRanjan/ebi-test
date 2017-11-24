package org.ebi.business.dto;

import lombok.Data;

@Data
public class ProjectDTO {
    private String projectId;
    private String title;
    private String sourceType;
    private String studyType;
    private String evaCenterName;
    private String centerName;
    private Integer taxonomyId;
}
