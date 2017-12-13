package org.ebi.rest.controller;

import org.ebi.business.service.TaxonomyService;
import org.ebi.entity.TaxonomyEntity;
import org.ebi.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxonomies")
public class TaxonomyController {

    @Autowired
    private TaxonomyService taxonomyService;

    @GetMapping
    public ResponseEntity<List<TaxonomyEntity>>  find(
            @RequestParam(required = false) String taxonomyCommonName,
            @RequestParam(required = false) String taxonomyScientificName){
        return ResponseEntity.ok(taxonomyService.find(taxonomyCommonName, taxonomyScientificName));
    }

    @GetMapping("/{taxonomyId}")
    public ResponseEntity<TaxonomyEntity>  findOne(@PathVariable Integer taxonomyId){
        return ResponseEntity.ok(taxonomyService.findById(taxonomyId));
    }

    @PostMapping
    public ResponseEntity<Integer>  create(@RequestBody TaxonomyEntity entity){
        return ResponseEntity.ok(taxonomyService.save(entity));
    }

    @PutMapping("/{taxonomyId}")
    public ResponseEntity<TaxonomyEntity>  update(@PathVariable Integer taxonomyId, @RequestBody TaxonomyEntity entity){
       return ResponseEntity.ok(taxonomyService.update(taxonomyId, entity));
    }

    @DeleteMapping("/{taxonomyId}")
    public ResponseEntity  delete(@PathVariable Integer taxonomyId){
        taxonomyService.delete(taxonomyId);
       return ResponseEntity.ok(null);
    }
}
