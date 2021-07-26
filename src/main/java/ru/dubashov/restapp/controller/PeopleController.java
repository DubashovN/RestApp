package ru.dubashov.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dubashov.restapp.entity.People;
import ru.dubashov.restapp.service.PeopleService;

import java.util.List;

@Controller
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/")
    public List<People> getAll(){
        return peopleService.findAll();
    }

    @GetMapping("/add")
    public void add(){

    }

}
