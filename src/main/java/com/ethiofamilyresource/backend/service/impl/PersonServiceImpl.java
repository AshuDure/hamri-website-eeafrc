package com.ethiofamilyresource.backend.service.impl;

import com.ethiofamilyresource.backend.dto.PersonDto;
import com.ethiofamilyresource.backend.entity.Person;
import com.ethiofamilyresource.backend.exception.ResourceNotFoundException;
import com.ethiofamilyresource.backend.mapper.PersonMapper;
import com.ethiofamilyresource.backend.repository.PersonRepository;
import com.ethiofamilyresource.backend.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto updatePerson(Long personId, PersonDto updatedPerson) {
        Person person = personRepository.findById(personId).orElseThrow(
                 () -> new ResourceNotFoundException("Person doesn't exist with given id: " + personId)
         );
        person.setFirstName(updatedPerson.getFirstName());
        person.setLastName(updatedPerson.getLastName());
        person.setEmail(updatedPerson.getEmail());
        person.setPhoneNumber(updatedPerson.getPhoneNumber());

        Person updatedPersonObj = personRepository.save(person);
        return PersonMapper.mapToPersonDto(updatedPersonObj);
    }

    @Override
    public void deletePerson(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new ResourceNotFoundException("Person doesn't exist with given id: " + personId)
        );

        personRepository.deleteById(personId);
    }
}
