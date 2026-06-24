package com.example.demo.service;

import com.example.demo.dto.Message;
import com.example.demo.dto.Person;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final MessageRepository messageRepository;

    public PersonService(PersonRepository personRepository, MessageRepository messageRepository) {
        this.personRepository = personRepository;
        this.messageRepository = messageRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(int id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(int id, Person person) {
        Person existing = personRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existing.setFirstname(person.getFirstname());
        existing.setSurname(person.getSurname());
        existing.setLastname(person.getLastname());
        existing.setBirthday(person.getBirthday());
        return personRepository.save(existing);
    }

    public void delete(int id) {
        if (!personRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        personRepository.deleteById(id);
    }

    public List<Message> getPersonMessages(int personId) {
        if (!personRepository.existsById(personId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return messageRepository.findByPersonId(personId);
    }

    public Message getPersonMessage(int personId, int messageId) {
        if (!personRepository.existsById(personId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return messageRepository.findByIdAndPersonId(messageId, personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Message addMessageToPerson(int personId, Message message) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        message.setPerson(person);
        return messageRepository.save(message);
    }

    public void deletePersonMessage(int personId, int messageId) {
        if (!personRepository.existsById(personId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Message message = messageRepository.findByIdAndPersonId(messageId, personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        messageRepository.delete(message);
    }
}
