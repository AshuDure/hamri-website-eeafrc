package com.ethiofamilyresource.backend.service;

import com.ethiofamilyresource.backend.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);

    PersonDto getPersonById(Long personId);

    List<PersonDto> getAllPersons();

    PersonDto updatePerson(Long personId, PersonDto updatedPerson);

    void deletePerson(Long personId);
}
