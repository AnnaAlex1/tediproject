package com.devproject.tediproject.controller;

import com.devproject.tediproject.exception.ConnectionRequestNotFoundException;
import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.ConnectionRequestId;
import com.devproject.tediproject.model.Professional;
import com.devproject.tediproject.payload.ConnectionAddRequest;
import com.devproject.tediproject.repository.ConnectionRequestRepository;
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

        ConnectionRequest newConnectionRequest =
                new ConnectionRequest(newConnectionRequestId);


        //TODO: request not arriving from frontend
        return repository.save(newConnectionRequest);
    }

    @GetMapping("/connectionrequests")
    List<ConnectionRequest> get_All() { return  repository.findAll(); }

    @GetMapping("/connectionrequests/{id}")
    ConnectionRequest get_one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ConnectionRequestNotFoundException(id));
    }

    @DeleteMapping("connectionrequests/delete/{id}")
    void deleteConnectionRequest(@PathVariable Long id) { repository.deleteById(id);}

}
