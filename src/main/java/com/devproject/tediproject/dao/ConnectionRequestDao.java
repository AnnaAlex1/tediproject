package com.devproject.tediproject.dao;

import com.devproject.tediproject.model.ConnectionRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ConnectionRequestDao implements Dao<ConnectionRequest>{

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

    @Override
    public void update(ConnectionRequest connectionRequest, String[] params){
        connectionRequest.setFrom(Long.parseLong(params[0]));
        connectionRequest.setTo(Long.parseLong(params[1]));
        connectionRequest.setFromIsFollowingTo(Integer.parseInt(params[2]));
        connectionRequest.setToIsFollowingFrom(Integer.parseInt(params[3]));

        connectionRequests.add(connectionRequest);
    }

    @Override
    public void delete(ConnectionRequest connectionRequest){
        connectionRequests.remove(connectionRequest);
    }

}
