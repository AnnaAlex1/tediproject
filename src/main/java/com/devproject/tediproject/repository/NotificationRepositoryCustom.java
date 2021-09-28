package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Notification;

import java.util.List;

public interface NotificationRepositoryCustom {
    public List<Notification> getRestOfNotifications(Long profId);
}
