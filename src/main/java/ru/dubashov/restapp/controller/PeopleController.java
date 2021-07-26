package ru.dubashov.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dubashov.restapp.entity.People;
import ru.dubashov.restapp.service.PeopleService;

import java.util.List;

@RequestMapping("/people")
@RestController
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<People>> getAll(){
        return ResponseEntity.ok().body(peopleService.findAll());
    }

    @GetMapping("/add")
    public void add(){

    }
}
