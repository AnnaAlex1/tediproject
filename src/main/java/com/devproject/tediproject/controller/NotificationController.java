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

    @GetMapping("/notifications")
    List<Notification> get_All() { return repository.findAll(); }

    @GetMapping("/notifications/{id}")
    Notification get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException(id));
    }

    @PutMapping("/notifications/{id}")
    Notification replaceNotification(@RequestBody Notification newNotification, @PathVariable Long id){

        return repository.findById(id)
                .map(notification -> {
                    notification.setIdNotification(newNotification.getIdNotification());
                    notification.setText(newNotification.getText());
                    notification.setC_request(newNotification.getC_request());
                    notification.setPost(newNotification.getPost());
                    notification.setProf(newNotification.getProf());
                    notification.setLike(newNotification.getLike());
                    return repository.save(notification);
                })
                .orElseGet(() -> {
                    newNotification.setIdNotification(id);
                    return repository.save(newNotification);
                });
    }

    @DeleteMapping("/notifications/{id}")
    void deleteNotification(@PathVariable Long id) { repository.deleteById(id); }

}
