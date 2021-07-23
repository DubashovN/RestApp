package ru.dubashov.restapp.model;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dubashov.restapp.entity.People;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
