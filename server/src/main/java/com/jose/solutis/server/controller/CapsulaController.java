package com.jose.solutis.server.controller;


import com.jose.solutis.server.data.CapsulaRepository;
import com.jose.solutis.server.models.CapsulaCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("")
public class CapsulaController {

    @Autowired
    private CapsulaRepository repository;


    @GetMapping("/capsulas")
    public List<CapsulaCafe> allCapsula(){
        return repository.findAll();
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

}
