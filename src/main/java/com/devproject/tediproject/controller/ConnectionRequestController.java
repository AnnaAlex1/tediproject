package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.ConnectionRequestId;
import com.devproject.tediproject.model.Conversations;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ConnectionAddRequest;
import com.devproject.tediproject.repository.ConnectionRequestRepository;
import com.devproject.tediproject.repository.ConversationsRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConnectionRequestController {

    private final ConnectionRequestRepository repository;

    @Autowired
    private ProfessionalRepository profRepository;

    @Autowired
    private ConversationsRepository conversationsRepository;


    public ConnectionRequestController(ConnectionRequestRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/connectionrequests/add")
    ConnectionRequest newConnectionRequest(@RequestBody ConnectionAddRequest connectionAddRequest) {

        //get professional who requests
        Optional<Professional> res = profRepository.findById(connectionAddRequest.getFrom());
        Professional profFrom = res.get();

        //get professional requested
        Optional<Professional> res2 = profRepository.findById(connectionAddRequest.getTo());
        Professional profTo = res2.get();

        ConnectionRequestId newConnectionRequestId = new ConnectionRequestId(profFrom, profTo);
//        ConnectionRequest newConnectionRequest =
//                new ConnectionRequest(profFrom, profTo);

        ConnectionRequest newConnectionRequest = new ConnectionRequest(newConnectionRequestId);


        // create a new conversation
        Conversations newConversation = new Conversations(profTo, profFrom);
        conversationsRepository.save(newConversation);

        return repository.save(newConnectionRequest);
    }


    @PutMapping("/connectionrequests/update")
    ConnectionRequest updateConnectionRequest(@RequestBody ConnectionRequest updConnectionRequest){
        Optional<ConnectionRequest> res = repository.findById(updConnectionRequest.getIdFromTo());
        ConnectionRequest oldConnectionRequest = res.get();

        oldConnectionRequest.setFromIsFollowingTo(true);
        return repository.save(oldConnectionRequest);
    }


    @GetMapping("/connectionrequests/prof/{profId}")
    List<ConnectionRequest> getConnectionRequests(@PathVariable String profId) {
        return repository.getCRForProf(Long.parseLong(profId));
    }


    @DeleteMapping("connectionrequests/delete/{fromId}/{toId}")
    void deleteConnectionRequest(@PathVariable String fromId, @PathVariable String toId) {
        repository.deleteConnectionRequest(Long.parseLong(fromId), Long.parseLong(toId));
    }




}
