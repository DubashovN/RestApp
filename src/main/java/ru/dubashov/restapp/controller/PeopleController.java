package ru.dubashov.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dubashov.restapp.entity.People;
import ru.dubashov.restapp.service.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<People>> getAll() {
        return ResponseEntity.ok().body(peopleService.findAll());
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<People> getByID(@PathVariable(name = "id") Integer id) {

        People people = this.peopleService.getById(id);
        if (people != null){
            return new ResponseEntity<>(people, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/add")
    public ResponseEntity<People> add(@RequestBody People people) {
        return ResponseEntity.ok().body(peopleService.create(people));
    }

    @PostMapping("/delete")
    public ResponseEntity<People> delete(@RequestBody Integer id) {
        People people1 = peopleService.getById(id);

        if (people1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.peopleService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
