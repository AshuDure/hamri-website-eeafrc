package com.ethiofamilyresource.backend.mapper;

import com.ethiofamilyresource.backend.dto.PersonDto;
import com.ethiofamilyresource.backend.entity.Person;

public class PersonMapper {
    public static PersonDto mapToPersonDto(Person person){
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getEmail(),
                person.getPhoneNumber()
        );
    }

    public static Person mapToPerson(PersonDto personDto){
        return new Person(
                personDto.getId(),
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getEmail(),
                personDto.getPhoneNumber()
        );
    }
}
