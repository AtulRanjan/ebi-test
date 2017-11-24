package org.ebi.business.service.impl;

import org.ebi.business.service.TaxonomyService;
import org.ebi.entity.TaxonomyEntity;
import org.ebi.repository.TaxonomyRepository;
import org.ebi.rest.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxonomyServiceImpl  implements TaxonomyService{
    @Autowired
    private TaxonomyRepository taxonomyRepository;
    @Override
    public List<TaxonomyEntity> find(String taxonomyCommonName, String taxonomyScientificName) {
        TaxonomyEntity filter = new TaxonomyEntity();
        filter.setTaxonomyCommonName(taxonomyCommonName);
        filter.setTaxonomyScientificName(taxonomyScientificName);
        Example example = Example.of(filter, ExampleMatcher.matching().withIgnoreNullValues());
        return taxonomyRepository.findAll(example);
    }

    @Override
    public TaxonomyEntity findById(Integer taxonomyId) {
        TaxonomyEntity taxonomyEntity = taxonomyRepository.findOne(taxonomyId);
        if(null == taxonomyEntity){
            throw new BadRequestException(-1, String.format("No data found with ID %s", taxonomyId));
        }
        return taxonomyEntity;
    }

    @Override
    public Integer save(TaxonomyEntity taxonomyEntity) {
        return taxonomyRepository.save(taxonomyEntity).getTaxonomyId();
    }

    @Override
    public void delete(Integer taxonomyId) {
        findById(taxonomyId);
        taxonomyRepository.delete(taxonomyId);
    }

    @Override
    public TaxonomyEntity update(Integer taxonomyId, TaxonomyEntity taxonomyEntity) {
        findById(taxonomyId);
        taxonomyEntity.setTaxonomyId(taxonomyId);
        return taxonomyRepository.save(taxonomyEntity);
    }
}
