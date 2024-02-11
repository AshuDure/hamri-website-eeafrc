package com.ethiofamilyresource.backend.service.impl;

import com.ethiofamilyresource.backend.dto.PersonDto;
import com.ethiofamilyresource.backend.entity.Person;
import com.ethiofamilyresource.backend.exception.ResourceNotFoundException;
import com.ethiofamilyresource.backend.mapper.PersonMapper;
import com.ethiofamilyresource.backend.repository.PersonRepository;
import com.ethiofamilyresource.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savedPerson = personRepository.save(person);
        return PersonMapper.mapToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        Person person = personRepository.findById(personId)
                 .orElseThrow(() ->
                         new ResourceNotFoundException("Person doesn't exist with given id: " + personId));
        return PersonMapper.mapToPersonDto(person);
    }
}
