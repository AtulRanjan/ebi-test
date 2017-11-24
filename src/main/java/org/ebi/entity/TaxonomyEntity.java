package org.ebi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TAXONOMIES")
@Data
public class TaxonomyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taxonomyId;
    private String taxonomyCommonName;
    private String taxonomyScientificName;
    @JsonIgnore
    @OneToMany(mappedBy = "taxonomy")
    private List<ProjectEntity> projects;
}
