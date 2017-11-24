package org.ebi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity(name = "PROJECTS")
@Data
public class ProjectEntity {
    @Id
    private String projectId;
    private String title;
    @Column(length = 4000)
    private String description;
    private String sourceType;
    private String studyType;
    private String evaCenterName;
    private String centerName;
//    private Integer taxonomyId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="taxonomy_id",nullable = true)
    @JsonIgnore
    private TaxonomyEntity taxonomy;
}
