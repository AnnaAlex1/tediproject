package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.MessageNotFoundException;
import com.devproject.tediproject.model.Message;
import com.devproject.tediproject.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) { return repository.save(newMessage); }

    @GetMapping("/messages")
    List<Message> get_All() { return repository.findAll(); }

    @GetMapping("/messages/{id}")
    Message get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id){

        return repository.findById(id)
                .map(message -> {
                    message.setIdMessage(newMessage.getIdMessage());
                    message.setIdprofessional1(newMessage.getIdprofessional1());
                    message.setIdprofessional2(newMessage.getIdprofessional2());
                    message.setText(newMessage.getText());
                    message.setDate_time(newMessage.getDate_time());
                    return repository.save(message);
                })
                .orElseGet(() -> {
                    newMessage.setIdMessage(id);
                    return repository.save(newMessage);
                });
    }

    @DeleteMapping("/message/{id}")
    void deleteMessage(@PathVariable Long id) { repository.deleteById(id); }
}
