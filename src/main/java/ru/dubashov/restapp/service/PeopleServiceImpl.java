package ru.dubashov.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dubashov.restapp.entity.People;
import ru.dubashov.restapp.model.PeopleRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Autowired
    public PeopleRepository getPeopleRepository() {
        return peopleRepository;
    }

    @Override
    public People getById(int id) {
        return peopleRepository.getById(id);
    }

    @Override
    public void savePeople(People people) {
        peopleRepository.save(people);
    }

    @Override
    public void updatePeople(Integer id, String surname, String name, String patronymic, LocalDate birthDate, int phoneNumber, String eMail) {
        People updatePeople = peopleRepository.getById(id);
        updatePeople.setSurname(surname);
        updatePeople.setName(name);
        updatePeople.setPatronymic(patronymic);
        updatePeople.setBirthDate(birthDate);
        updatePeople.setPhoneNumber(phoneNumber);
        updatePeople.seteMail(eMail);
    }

    @Override
    public void deletePeople(int id) {
        peopleRepository.deleteById(id);
    }

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }
}
