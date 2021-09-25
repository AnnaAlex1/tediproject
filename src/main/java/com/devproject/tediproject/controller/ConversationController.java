package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.Conversations;
import com.devproject.tediproject.repository.ConversationsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConversationController {

    private final ConversationsRepository repository;

    public ConversationController(ConversationsRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/conversations/{profId}")
    List<Conversations> getConversations(@PathVariable String profId){
        return repository.getConversationsByProf1(Long.parseLong(profId));
    }



}
