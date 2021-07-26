package ru.dubashov.restapp.service;

import ru.dubashov.restapp.entity.People;

import java.time.LocalDate;
import java.util.List;

public interface PeopleService {
    People getById(int id);

    void savePeople(People people);

    void updatePeople(Integer id, String surname, String patronymic, String name, LocalDate birthDate, int phoneNumber, String eMail);

    void deletePeople(int id);

    List<People> findAll();
}
