package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

public class NotificationDao implements Dao<Notification> {

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

    @Override
    public void update(Notification notification, String[] params){
        notification.setIdNotification(requireNonNull(Long.parseLong(params[0]),"IdMessage cannot be null"));
        notification.setText(params[1]);

        notifications.add(notification);

        //set post, connection_request, like
    }

    @Override
    public void delete(Notification notification){
        notifications.remove(notification);
    }
}
