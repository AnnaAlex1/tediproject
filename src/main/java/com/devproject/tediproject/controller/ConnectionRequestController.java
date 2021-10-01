package com.devproject.tediproject.controller;

import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.ConnectionRequestId;
import com.devproject.tediproject.model.Conversations;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ConnectionAddRequest;
import com.devproject.tediproject.repository.ConnectionRequestRepository;
import com.devproject.tediproject.repository.ConversationsRepository;
import com.devproject.tediproject.repository.ProfessionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


        return repository.save(newConnectionRequest);
    }

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);


    @CrossOrigin(origins = "*")
    @PutMapping("/connectionrequests/update")
    ConnectionRequest updateConnectionRequest(@RequestBody ConnectionRequest updConnectionRequest){
        Optional<ConnectionRequest> res = repository.findById(updConnectionRequest.getIdFromTo());
        ConnectionRequest oldConnectionRequest = res.get();


        oldConnectionRequest.setFromIsFollowingTo(updConnectionRequest.getFromIsFollowingTo());
        oldConnectionRequest.setToIsFollowingFrom(updConnectionRequest.getToIsFollowingFrom());

        logger.info("FromTo " + oldConnectionRequest.getFromIsFollowingTo() + " To: " + oldConnectionRequest.getToIsFollowingFrom());
        // create a new conversation
        Conversations newConversation = new Conversations(res.get().getIdFromTo().getTo(), res.get().getIdFromTo().getFrom());
        conversationsRepository.save(newConversation);

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
