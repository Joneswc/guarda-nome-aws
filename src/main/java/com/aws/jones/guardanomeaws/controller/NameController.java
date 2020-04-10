package com.aws.jones.guardanomeaws.controller;

import com.aws.jones.guardanomeaws.model.Name;
import com.aws.jones.guardanomeaws.repository.NameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/name")
public class NameController {

    private NameRepository nameRepository;

    public NameController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @GetMapping
    public List names(){
        return (List) nameRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getNameById(@PathVariable long id) {
        return nameRepository.findById(id)
                .map(( name -> ResponseEntity.ok().body(name) ))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Name create(@RequestBody Name name) {
        return nameRepository.save(name);
    }

}
