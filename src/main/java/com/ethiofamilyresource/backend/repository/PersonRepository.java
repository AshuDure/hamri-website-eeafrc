package com.ethiofamilyresource.backend.repository;

import com.ethiofamilyresource.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
