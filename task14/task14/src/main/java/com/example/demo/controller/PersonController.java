package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.dto.Person;
import com.example.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable int id) {
        return personService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable int id, @RequestBody Person person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        personService.delete(id);
    }

    @GetMapping("/{personId}/message")
    public List<Message> getPersonMessages(@PathVariable int personId) {
        return personService.getPersonMessages(personId);
    }

    @GetMapping("/{personId}/message/{messageId}")
    public Message getPersonMessage(@PathVariable int personId, @PathVariable int messageId) {
        return personService.getPersonMessage(personId, messageId);
    }

    @PostMapping("/{personId}/message")
    @ResponseStatus(HttpStatus.CREATED)
    public Message addMessageToPerson(@PathVariable int personId, @RequestBody Message message) {
        return personService.addMessageToPerson(personId, message);
    }

    @DeleteMapping("/{personId}/message/{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonMessage(@PathVariable int personId, @PathVariable int messageId) {
        personService.deletePersonMessage(personId, messageId);
    }
}
