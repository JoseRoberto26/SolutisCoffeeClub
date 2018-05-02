package com.jose.solutis.server.controller;


import com.jose.solutis.server.data.CapsulaRepository;
import com.jose.solutis.server.models.CapsulaCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class CapsulaController {

    @Autowired
    private CapsulaRepository repository;

    @GetMapping("/capsulas")
    public List<CapsulaCafe> allCapsula(){
        return repository.findAll();
    }

    @GetMapping("/capsulas/{id}")
    public Optional<CapsulaCafe> getCapsulaById(@PathVariable long id){
        return repository.findById(id);
    }

    @DeleteMapping("/capsulas/{id}")
    public void deleteCapsula(@PathVariable long id){
        repository.deleteById(id);
    }

    @PostMapping("/capsulas")
    public ResponseEntity<Object> createCapsula(@RequestBody CapsulaCafe capsulaCafe){
        CapsulaCafe novaCapsula = (CapsulaCafe) repository.save(capsulaCafe);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCapsula.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
    @PutMapping("/capsulas/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody CapsulaCafe capsulaCafe, @PathVariable long id) {

        Optional<CapsulaCafe> studentOptional = repository.findById(id);

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        capsulaCafe.setId(id);

        repository.save(capsulaCafe);

        return ResponseEntity.noContent().build();
    }

}
