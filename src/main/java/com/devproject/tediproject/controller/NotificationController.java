package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.NotificationNotFoundException;
import com.devproject.tediproject.model.Notification;
import com.devproject.tediproject.repository.NotificationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationRepository repository;

    NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/notifications")
    Notification newNotification(@RequestBody Notification newNotification) { return repository.save(newNotification); }

    @GetMapping("/notifications/{profId}/all")
    List<Notification> getRestOfNotifications(@PathVariable String profId) {
        return repository.getRestOfNotifications(Long.parseLong(profId));
    }

    @DeleteMapping("/notifications/{id}")
    void deleteNotification(@PathVariable Long id) { repository.deleteById(id); }

}
