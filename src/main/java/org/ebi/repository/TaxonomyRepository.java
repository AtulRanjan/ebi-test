package org.ebi.repository;

import org.ebi.entity.TaxonomyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepository extends CrudRepository<TaxonomyEntity, Integer>{
}
