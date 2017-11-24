package org.ebi.rest.controller;

import org.ebi.entity.TaxonomyEntity;
import org.ebi.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taxonomies")
public class TaxonomyController {

    @Autowired
    private TaxonomyRepository taxonomyRepository;
    @GetMapping
    public ResponseEntity<List<TaxonomyEntity>>  getAll(){
        return ResponseEntity.ok((List)taxonomyRepository.findAll());
    }
    @GetMapping("/{taxonomyId}")
    public ResponseEntity<TaxonomyEntity>  findOne(@PathVariable Integer taxonomyId){
        return ResponseEntity.ok(taxonomyRepository.findOne(taxonomyId));
    }
}
