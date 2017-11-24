package org.ebi.business.service;

import org.ebi.entity.TaxonomyEntity;

import java.util.List;

public interface TaxonomyService {
    List<TaxonomyEntity> find(String taxonomyCommonName, String taxonomyScientificName);
    TaxonomyEntity findById(Integer taxonomyId);
    Integer save(TaxonomyEntity taxonomyEntity);
    void delete(Integer taxonomyId);
    TaxonomyEntity update(Integer taxonomyId, TaxonomyEntity taxonomyEntity);
}
