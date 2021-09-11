package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.ConnectionRequest;
import com.devproject.tediproject.model.Professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class ConnectionRequestDao implements Dao<ConnectionRequest>{

    private List<ConnectionRequest> connectionRequests = new ArrayList<>();

    public ConnectionRequestDao(List<ConnectionRequest> connectionRequests) {
        this.connectionRequests = connectionRequests;
    }

    @Override
    public Optional<ConnectionRequest> get(long id){
        return Optional.ofNullable(connectionRequests.get((int)id));
    }

    @Override
    public List<ConnectionRequest> getAll(){
        return connectionRequests;
    }

    @Override
    public void insert(ConnectionRequest connectionRequest){
        connectionRequests.add(connectionRequest);
    }


    public void update(ConnectionRequest connectionRequest, Professional from, Professional to, Boolean fromTo, Boolean toFrom ){
        connectionRequest.setFrom(from);
        connectionRequest.setTo(to);
        connectionRequest.setFromIsFollowingTo(fromTo);
        connectionRequest.setToIsFollowingFrom(toFrom);
        connectionRequests.add(connectionRequest);
    }

    @Override
    public void delete(ConnectionRequest connectionRequest){
        connectionRequests.remove(connectionRequest);
    }

}
