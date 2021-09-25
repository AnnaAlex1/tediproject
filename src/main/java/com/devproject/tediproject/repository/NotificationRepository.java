package com.devproject.tediproject.repository;

import com.devproject.tediproject.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long>, NotificationRepositoryCustom {
}
