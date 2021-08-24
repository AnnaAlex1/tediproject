package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Message;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.*;

public class MessageDao implements Dao<Message> {

    private List<Message> messages = new ArrayList<>();

    public MessageDao(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public Optional<Message> get(long id){
        return Optional.ofNullable(messages.get((int)id));
    }

    @Override
    public List<Message> getAll(){
        return messages;
    }

    @Override
    public void insert(Message message){
        messages.add(message);
    }

    @Override
    public void update(Message message, String[] params){
        message.setIdMessage(requireNonNull(Long.parseLong(params[0]),"IdMessage cannot be null"));
        //message.setIdprofessional1(requireNonNull(Long.parseLong(params[1]),"IdProfessional1 cannot be null"));
        //message.setIdprofessional2(requireNonNull(Long.parseLong(params[2]),"IdProfessional2 cannot be null"));
        message.setText(params[1]);
        message.setDate_time(DateTimeFormatter.ofPattern(params[2]));

        //set prof1,prof2,pic,video

        messages.add(message);
    }

    @Override
    public void delete(Message message){
        messages.remove(message);
    }

}
