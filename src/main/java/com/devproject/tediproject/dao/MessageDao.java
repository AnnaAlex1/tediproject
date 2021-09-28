package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Content;
import com.devproject.tediproject.model.Message;
import com.devproject.tediproject.model.Professional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public abstract class MessageDao implements Dao<Message> {

    private List<Message> messages = new ArrayList<>();

    public MessageDao(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public Optional<Message> get(long id){
        return Optional.ofNullable(messages.get((int)id));
    }

    @Override
    public List<Message> getAll(){ return messages; }

    @Override
    public void insert(Message message){
        messages.add(message);
    }


    public void update(Message message, Long messageId, List<Content> content, Timestamp date, Professional prof1, Professional prof2){
        message.setIdMessage(messageId);
        message.setContent(content);
        message.setDate_time(date);
//        message.setProf1(prof1);
//        message.setProf2(prof2);

        messages.add(message);
    }

    @Override
    public void delete(Message message){
        messages.remove(message);
    }

}
