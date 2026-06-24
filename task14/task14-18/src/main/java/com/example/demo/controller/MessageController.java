package com.example.demo.controller;

import com.example.demo.dto.Message;
import com.example.demo.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable int id) {
        return messageService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message create(@RequestBody Message message) {
        return messageService.create(message);
    }

    @PutMapping("/{id}")
    public Message update(@PathVariable int id, @RequestBody Message message) {
        return messageService.update(id, message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        messageService.delete(id);
    }
}
