package ru.dubashov.restapp.service;

import ru.dubashov.restapp.entity.People;

import java.util.List;

public interface PeopleService {
    People getById(Integer id);

    People create(People people);

    void updatePeople(Integer id, String surname, String patronymic, String name, String phoneNumber, String eMail);

    void deletePeople(Integer id);

    List<People> findAll();
}
