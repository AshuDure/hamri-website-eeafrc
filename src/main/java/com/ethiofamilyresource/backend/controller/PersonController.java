package com.ethiofamilyresource.backend.controller;

import com.ethiofamilyresource.backend.dto.PersonDto;
import com.ethiofamilyresource.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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

    // Build GET ALL Person REST API
    @GetMapping
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        List<PersonDto> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }

    // Build UPDATE Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("id") Long personId,
                                                  @RequestBody PersonDto updatedPerson){
        PersonDto personDto = personService.updatePerson(personId, updatedPerson);
        return ResponseEntity.ok(personDto);
    }

    // Build DELETE REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long personId){
        personService.deletePerson(personId);
        return ResponseEntity.ok("Employee deleted successfully!");
    }
}
