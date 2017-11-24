package org.ebi.repository;

import org.ebi.entity.TaxonomyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepository extends JpaRepository<TaxonomyEntity, Integer> {
}
