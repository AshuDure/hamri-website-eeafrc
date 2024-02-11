package com.ethiofamilyresource.backend.controller;

import com.ethiofamilyresource.backend.dto.PersonDto;
import com.ethiofamilyresource.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonService personService;

    // Build ADD Person REST API
    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        PersonDto savedPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    // Build GET Person REST API
    @GetMapping("{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") Long personId){
        PersonDto personDto = personService.getPersonById(personId);
        return ResponseEntity.ok(personDto);
    }
}
