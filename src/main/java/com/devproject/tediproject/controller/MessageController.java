package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.MessageNotFoundException;
import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Conversations;
import com.devproject.tediproject.model.Message;
import com.devproject.tediproject.payload.MessageAddRequest;
import com.devproject.tediproject.repository.ContentRepository;
import com.devproject.tediproject.repository.ConversationsRepository;
import com.devproject.tediproject.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private final MessageRepository repository;

    @Autowired
    private ConversationsRepository convRepository;

    @Autowired
    private ContentRepository contentRepository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("conversations/{convId}//message/add")
    Message newMessage(@RequestBody MessageAddRequest newMessageReq) {

        // get conversations
        Optional<Conversations> res = convRepository.findById(newMessageReq.getConversationId());
        Conversations conversation = res.get();

        Message newMessage = new Message(conversation);
        repository.save(newMessage);

        //create list of content
        List<Content> newContent = new ArrayList<Content>();
        for (int i=0; i<newMessageReq.getContent().size(); i++){
            newContent.add(new Content(newMessageReq.getContent().get(i).getType(),
                    newMessageReq.getContent().get(i).getPath(), newMessage) );
        }

        // for new message
        newMessage.setContent(newContent); //set content of new message
        repository.save(newMessage); //add message in database


        //for conversation
        conversation.setWasRead(false);
        conversation.addInMessageList(newMessage); //add message to conversation class
        convRepository.save(conversation); //update conversation

        //add content to array of contents
        for (int i=0; i<newContent.size(); i++) {
            contentRepository.save(newContent.get(i));
        }

        return newMessage;
    }

    @GetMapping("conversations/{convId}/messages/all")
    List<Message> getMessagesOfConversation(@PathVariable Long convId){
        return repository.findByConversationId(convId);
    }

    @DeleteMapping("conversations/{convId}/messages/{id}")
    void deleteMessage(@PathVariable Long id) { repository.deleteById(id); }
}
