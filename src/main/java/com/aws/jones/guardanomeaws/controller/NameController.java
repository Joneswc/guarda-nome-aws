package com.aws.jones.guardanomeaws.controller;

import com.aws.jones.guardanomeaws.model.Name;
import com.aws.jones.guardanomeaws.repository.NameRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NameController {

    private NameRepository nameRepository;

    public NameController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @PostMapping("/memoname")
    public ResponseEntity memoName( @RequestBody Name name ){
        Name nm = new Name();
        nm.setName(name.getName());
        return ResponseEntity.ok("Hello, " + nm.getName());
    }

    @GetMapping
    public ResponseEntity started(){
        System.out.println("started");
        return ResponseEntity.ok("Great Times Are Comming");
    }

    @GetMapping("names")
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
