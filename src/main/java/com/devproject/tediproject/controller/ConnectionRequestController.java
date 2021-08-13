package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ConnectionRequestNotFoundException;
import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.repository.ConnectionRequestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectionRequestController {

    private final ConnectionRequestRepository repository;

    public ConnectionRequestController(ConnectionRequestRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/connectionrequests")
    ConnectionRequest newConnectionRequest(@RequestBody ConnectionRequest newConnectionRequest) { return repository.save(newConnectionRequest); }

    @GetMapping("/connectionrequests")
    List<ConnectionRequest> get_All() { return  repository.findAll(); }

    @GetMapping("/connectionrequests/{id}")
    ConnectionRequest get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ConnectionRequestNotFoundException(id));
    }

    @DeleteMapping("connectionrequests/{id}")
    void deleteConnectionRequest(@PathVariable Long id) { repository.deleteById(id);}

}
