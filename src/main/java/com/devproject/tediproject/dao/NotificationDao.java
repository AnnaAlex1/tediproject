package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public abstract class NotificationDao implements Dao<Notification> {

    private List<Notification> notifications = new ArrayList<>();

    public NotificationDao(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public Optional<Notification> get(long id){
        return Optional.ofNullable(notifications.get((int)id));
    }

    @Override
    public List<Notification> getAll(){
        return notifications;
    }

    @Override
    public void insert(Notification notification){
        notifications.add(notification);
    }


    public void update(Notification notification, Long id, String text, Professional prof, Post post, ConnectionRequest request, Like like){

        notification.setIdNotification(id);
        notification.setText(text);
        notification.setProf(prof);
        notification.setPost(post);
        notification.setC_request(request);
        notification.setLike(like);
        notifications.add(notification);

    }

    @Override
    public void delete(Notification notification){
        notifications.remove(notification);
    }
}
