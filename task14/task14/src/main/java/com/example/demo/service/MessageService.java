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
public class MessageService {
    private final MessageRepository messageRepository;
    private final PersonRepository personRepository;

    public MessageService(MessageRepository messageRepository, PersonRepository personRepository) {
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
    }

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public Message getById(int id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Message create(Message message) {
        if (message.getPerson() != null && message.getPerson().getId() != 0) {
            int personId = message.getPerson().getId();
            if (!personRepository.existsById(personId)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            Person person = personRepository.findById(personId).get();
            message.setPerson(person);
        }
        return messageRepository.save(message);
    }

    public Message update(int id, Message message) {
        Message existing = messageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Person person = existing.getPerson();
        messageRepository.deleteById(id);
        message.setId(id);
        message.setPerson(person);
        return messageRepository.save(message);
    }

    public void delete(int id) {
        if (!messageRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        messageRepository.deleteById(id);
    }
}
