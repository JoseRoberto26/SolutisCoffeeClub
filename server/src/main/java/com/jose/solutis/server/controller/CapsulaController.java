package com.jose.solutis.server.controller;


import com.jose.solutis.server.data.CapsulaRepository;
import com.jose.solutis.server.models.CapsulaCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping(value = "/capsulas")
public class CapsulaController {

    @Autowired
    private CapsulaRepository repository;

    @GetMapping("")
    public List<CapsulaCafe> allCapsula(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CapsulaCafe> getCapsulaById(@PathVariable long id){
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCapsula(@PathVariable long id){
        repository.deleteById(id);
    }

    @PostMapping("  ")
    public ResponseEntity<Object> createCapsula(@RequestBody CapsulaCafe capsulaCafe){
        boolean existeCapsula = capsulaCafe.getId() != null;
        CapsulaCafe novaCapsula = (CapsulaCafe) repository.save(capsulaCafe);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaCapsula.getId()).toUri();

        if(existeCapsula) {
            return ResponseEntity.ok().body(capsulaCafe);
        }
        else{
            return ResponseEntity.created(location).body(capsulaCafe);
        }
    }


}
